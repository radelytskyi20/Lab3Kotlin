import java.util.LinkedList

interface IOrderService
{
    fun addOrder(order: IOrder)
    fun addOrders(orders: Collection<IOrder>)
    fun removeOrder(order: IOrder)
    fun removeOrder(orderId: Long)
    fun getOrderById(orderId: Long): IOrder?
    fun removeOrders(orders: Collection<IOrder>)
    fun getOrderInfo(orderId: Long)
    fun getOrderInfo(order: IOrder)
    fun getAllOrdersInfo()
}
class OrderService : IOrderService
{
    private var _orders: LinkedList<IOrder> = LinkedList()

    public override fun addOrder(order: IOrder){
        _orders.add(order)
        println("Заказ был успешно добавлен.")
    }
    public override fun addOrders(orders: Collection<IOrder>){
        _orders.addAll(orders)
        println("Заказы были успешно добавлены.")
    }
    public override fun removeOrder(order: IOrder){
        removeOrder(order.id)
    }
    public override fun removeOrder(orderId: Long){
        val order = getOrderById(orderId)
        if (order != null && order.orderStatus == OrderStatus.Done){
            _orders.remove(order)
            println("Заказ с $orderId был успешно удален.")
            return
        }

        println("Заказ с $orderId не был удален.")
    }
    public override fun getOrderById(orderId : Long) : IOrder? {
        val order = _orders.find { it.id == orderId }
        if (order == null){
            println("Заказ с id $orderId не найден.")
            return null;
        }
        else{
            return order
        }
    }
    public override fun removeOrders(orders : Collection<IOrder>){
        if (!orders.any())
        {
            println("Нет заказов к удалению.")
            return
        }
        for (order in orders) {
            removeOrder(order)
        }
    }
    public override fun getOrderInfo(orderId : Long){
        val order = getOrderById(orderId) ?: return
        println(order.toString())
    }
    public override fun getOrderInfo(order : IOrder){
        getOrderInfo(order.id)
    }
    public override fun getAllOrdersInfo(){
        for (order in _orders){
            getOrderInfo(order)
        }
    }
}