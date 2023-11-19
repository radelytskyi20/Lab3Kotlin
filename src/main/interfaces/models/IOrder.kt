import java.math.BigDecimal
interface IOrder{
    val id: Long
    val totalPrice: BigDecimal
    val orderStatus: OrderStatus
    val dishes: List<IDish> //mb change to MutableList
    val clients: List<IClient>
    val tableNumber : Int
    val paymentMethod: PaymentMethod //mb separate interface
}