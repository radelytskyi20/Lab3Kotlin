import java.lang.Exception
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

enum class OrderStatus{
    READY,
    IN_PROCESS,
    Done //when client got his order and pay it
}

enum class PaymentMethod{
    Cash,
    Card
}

class Order : IOrder{
    constructor(_client: IClient, _totalPrice: BigDecimal,
                _orderStatus: OrderStatus, _dish: IDish,
                _tableNumber: Int, _paymentMethod: PaymentMethod) :

    this(listOf(_client), _totalPrice, _orderStatus, listOf(_dish), _tableNumber, _paymentMethod)

    constructor(_clients: List<IClient>, _totalPrice: BigDecimal,
                _orderStatus: OrderStatus, _dishes: List<IDish>,
                _tableNumber: Int, _paymentMethod: PaymentMethod)
    {
        if (_totalPrice <= BigDecimal.ZERO || _tableNumber <= 0)
            throw Exception(ErrorMessages.INCORRECT_DATA_MESSAGE)

        id = ++idCounter
        clients = _clients
        totalPrice = _totalPrice
        orderStatus = _orderStatus
        dishes = _dishes
        tableNumber = _tableNumber
        paymentMethod = _paymentMethod
    }

    companion object{
        var idCounter: Long = 0
    }

    override var id: Long
        private set
    override var totalPrice: BigDecimal
        private set
    override var orderStatus: OrderStatus
        private set
    override var dishes: List<IDish>
        private set
    override var clients: List<IClient>
        private set
    override var tableNumber: Int
        private set
    override var paymentMethod: PaymentMethod
        private set

    override fun toString(): String {
        return "Order(id=$id, " +
                "totalPrice=$totalPrice, " +
                "orderStatus=$orderStatus, " +
                "dishes=$dishes, " +
                "clients=$clients, " +
                "tableNumber=$tableNumber, " +
                "paymentMethod=$paymentMethod)"
    }
}