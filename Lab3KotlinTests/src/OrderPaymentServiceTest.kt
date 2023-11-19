
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OrderPaymentServiceTest {
    private lateinit var orderPaymentService: OrderPaymentService

    @BeforeEach
    fun setUp() {
        orderPaymentService = OrderPaymentService()
    }
    @Test
    fun testAddPayment() {
        val payment = OrderPayment(1, 10.50, PaymentMethod.Card, "2023-01-01 14:30:00")
        orderPaymentService.addPayment(payment)

        val retrievedPayment = orderPaymentService.getPaymentById(1)
        assertEquals(payment, retrievedPayment)
    }
    @Test
    fun testRemovePayment() {
        val payment = OrderPayment(1, 10.50, PaymentMethod.Card, "2023-01-01 14:30:00")
        orderPaymentService.addPayment(payment)

        orderPaymentService.removePayment(payment.id)

        val retrievedPayment = orderPaymentService.getPaymentById(1)
        assertEquals(null, retrievedPayment)
    }
    @Test
    fun testGetAllPaymentsInfo() {
        @Test
        fun testGetAllPaymentsInfo() {
            val payment1 = OrderPayment(1, 10.50, PaymentMethod.Card, "2023-01-01 14:30:00")
            val payment2 = OrderPayment(2, 20.00, PaymentMethod.Cash, "2023-01-02 15:45:00")

            orderPaymentService.addPayment(payment1)
            orderPaymentService.addPayment(payment2)

            val expectedOutput = """
        ID платежа: 1, Сумма: 10.50, Метод: Card, Дата: 2023-01-01 14:30:00
        ID платежа: 2, Сумма: 20.00, Метод: Cash, Дата: 2023-01-02 15:45:00
    """.trimIndent()

            val capturedOutput = captureOutput {
                orderPaymentService.getAllPaymentsInfo()
            }

            assertEquals(expectedOutput, capturedOutput)
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