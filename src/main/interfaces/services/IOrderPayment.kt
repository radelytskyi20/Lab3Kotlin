interface IOrderPayment {
    val id: Long
    val amount: Double
    val paymentMethod: PaymentMethod
    val timestamp: String
}