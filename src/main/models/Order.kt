import java.lang.Exception
import java.math.BigDecimal

interface IOrder{
    val id: Long //maybe make static in the future
    val totalPrice: BigDecimal
    val orderStatus: OrderStatus
    //OrderedDishes
    //CustomerInfo
}

enum class OrderStatus{
    READY,
    IN_PROCESS
}

class Order(_id: Long, _totalPrice: BigDecimal, _orderStatus: OrderStatus) : IOrder{

    override var id: Long
        private set
    override var totalPrice: BigDecimal
        private set
    override var orderStatus: OrderStatus
        private set

    init {

        if (_id < 0 || _totalPrice < BigDecimal.ZERO)
            throw Exception("Incorrect data")

        id = _id
        totalPrice = _totalPrice
        orderStatus = _orderStatus
    }
}