import java.math.BigDecimal
fun main(){
    val ingredient1 = Ingredient("Tomato", 2.0, "pieces")
    val ingredient2 = Ingredient("Cheese", 150.0, "g")

    // Create a dish
    val client = Client("John", "+1234567890")
    val dish = Dish("Margherita Pizza", "A classic pizza", listOf(ingredient1, ingredient2))

    val clients = listOf(client)
    val dishes = listOf(dish)

    val order = Order(clients, BigDecimal("15.99"), OrderStatus.IN_PROCESS, dishes, 1, PaymentMethod.Card)
    // Print order
    println("Order ID: ${order.id}")
    println("Client: ${client.name}, Phone: ${client.phoneNumber}")
    println("Table Number: ${order.tableNumber}")
    println("Payment Method: ${order.paymentMethod}")
    println("Order Status: ${order.orderStatus}")
    println("Dishes:")
    for (dish in order.dishes) {
        println("  ${dish.name} - ${dish.description}")
        println("  Ingredients:")
        for (ingredient in dish.ingredients) {
            println("    ${ingredient.name}: ${ingredient.quantity} ${ingredient.unit}")
        }
    }
    println("Total Price: ${order.totalPrice}")
}