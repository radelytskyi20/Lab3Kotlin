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