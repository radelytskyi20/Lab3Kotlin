class OrderPayment(
    override val id: Long,
    override val amount: Double,
    override val paymentMethod: PaymentMethod,
    override val timestamp: String
) : IOrderPayment