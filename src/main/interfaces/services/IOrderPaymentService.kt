interface IOrderPaymentService {
    fun addPayment(payment: IOrderPayment)
    fun addPayments(payments: Collection<IOrderPayment>)
    fun removePayment(payment: IOrderPayment)
    fun removePayment(paymentId: Long)
    fun getPaymentById(paymentId: Long): IOrderPayment?
    fun removePayments(payments: Collection<IOrderPayment>)
    fun getPaymentInfo(paymentId: Long)
    fun getPaymentInfo(payment: IOrderPayment)
    fun getAllPaymentsInfo()
}
