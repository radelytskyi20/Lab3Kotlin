import java.math.BigDecimal
fun main(){

    val orderService = OrderService()
    val orderPaymentService = OrderPaymentService()
    val ingredient1 = Ingredient("Tomato", 2.0, "pieces")
    val ingredient2 = Ingredient("Cheese", 150.0, "g")
    val client = Client("John", "+1234567890")
    val dish = Dish("Margherita Pizza", "A classic pizza", listOf(ingredient1, ingredient2))

    val clients = listOf(client)
    val dishes = listOf(dish)

    val order = Order(clients, BigDecimal("15.99"), OrderStatus.IN_PROCESS, dishes, 1, PaymentMethod.Card)
    orderService.addOrder(order)
    orderService.getOrderInfo(order)
    val payment = OrderPayment(1, 15.99, PaymentMethod.Card, "08-11-2023 12:00:00")
    orderPaymentService.addPayment(payment)
    orderPaymentService.getAllPaymentsInfo()
}