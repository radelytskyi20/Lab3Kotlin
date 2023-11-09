import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.math.BigDecimal

class OrderServiceTest {

    private lateinit var orderService: OrderService
    @BeforeEach
    fun setUp() {
        orderService = OrderService()
    }
    @Test
    fun testAddOrder() {
        val client = Client("John", "+1234567890")
        val ingredient = Ingredient("Tomato", 2.0, "pieces")
        val dish = Dish("Margherita Pizza", "A classic pizza", listOf(ingredient))
        val order = Order(listOf(client), BigDecimal("15.99"), OrderStatus.IN_PROCESS, listOf(dish), 1, PaymentMethod.Card)

        orderService.addOrder(order)

        val retrievedOrder = orderService.getOrderById(order.id)
        assertEquals(order, retrievedOrder)
    }
    @Test
    fun testRemoveOrder() {
        val client = Client("John", "+1234567890")
        val ingredient = Ingredient("Tomato", 2.0, "pieces")
        val dish = Dish("Margherita Pizza", "A classic pizza", listOf(ingredient))
        val order = Order(listOf(client), BigDecimal("15.99"), OrderStatus.Done, listOf(dish), 1, PaymentMethod.Card)

        orderService.addOrder(order)

        orderService.removeOrder(order)

        val retrievedOrder = orderService.getOrderById(order.id)
        assertEquals(null, retrievedOrder)
    }
    @Test
    fun testGetAllOrdersInfo() {
        val client1 = Client("John", "+1234567890")
        val ingredient1 = Ingredient("Tomato", 2.0, "pieces")
        val dish1 = Dish("Margherita Pizza", "A classic pizza", listOf(ingredient1))
        val order1 = Order(listOf(client1), BigDecimal("15.99"), OrderStatus.IN_PROCESS, listOf(dish1), 1, PaymentMethod.Card)

        val client2 = Client("Alice", "+9876543210")
        val ingredient2 = Ingredient("Cheese", 150.0, "g")
        val dish2 = Dish("Pepperoni Pizza", "A spicy pizza", listOf(ingredient2))
        val order2 = Order(listOf(client2), BigDecimal("18.99"), OrderStatus.IN_PROCESS, listOf(dish2), 2, PaymentMethod.Cash)

        orderService.addOrder(order1)
        orderService.addOrder(order2)

        val expectedOutput = """
        Order(id=1,
        totalPrice=15.99,
        orderStatus=IN_PROCESS,
        dishes=[Dish(name='Margherita Pizza', description='A classic pizza', ingredients=[Ingredient(name='Tomato', quantity=2.0, unit='pieces')])],
        clients=[Client(name='John', phoneNumber='+1234567890')],
        tableNumber=1,
        paymentMethod=Card)
        Order(id=2,
        totalPrice=18.99,
        orderStatus=IN_PROCESS,
        dishes=[Dish(name='Pepperoni Pizza', description='A spicy pizza', ingredients=[Ingredient(name='Cheese', quantity=150.0, unit='g')])],
        clients=[Client(name='Alice', phoneNumber='+9876543210')],
        tableNumber=2,
        paymentMethod=Cash)
    """.trimIndent()

        val output = captureOutput { orderService.getAllOrdersInfo() }

        val expectedLines = expectedOutput.lines()
        val outputLines = output.lines()

        assertEquals(expectedLines.size, outputLines.size, "Number of lines mismatch")

        for ((index, expectedLine) in expectedLines.withIndex()) {
            assertEquals(expectedLine.trim(), outputLines[index].trim(), "Mismatch at line $index")
        }
    }
    private fun captureOutput(block: () -> Unit): String {
        val outputContent = System.out
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        block()

        System.setOut(outputContent)
        return outputStream.toString().trim()
    }
}