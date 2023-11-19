import java.util.LinkedList
class OrderPaymentService : IOrderPaymentService {
    private var payments: LinkedList<IOrderPayment> = LinkedList()

    override fun addPayment(payment: IOrderPayment) {
        payments.add(payment)
        println("Платеж успешно добавлен.")
    }

    override fun addPayments(payments: Collection<IOrderPayment>) {
        this.payments.addAll(payments)
        println("Платежи успешно добавлены")
    }

    override fun removePayment(payment: IOrderPayment) {
        payments.remove(payment)
        println("Платеж с ID ${payment.id} был успешно удален.")
    }

    override fun removePayment(paymentId: Long) {
        val payment = getPaymentById(paymentId)
        if (payment != null) {
            payments.remove(payment)
            println("Платеж с ID $paymentId был успешно удален.")
        } else {
            println("Платеж с ID $paymentId не был удален")
        }
    }

    override fun getPaymentById(paymentId: Long): IOrderPayment? {
        val payment = payments.find { it.id == paymentId }
        if (payment == null) {
            println("Платеж с ID $paymentId не найден.")
            return null
        } else {
            return payment
        }
    }

    override fun removePayments(payments: Collection<IOrderPayment>) {
        if (payments.isEmpty()) {
            println("Нет платежей для удаления.")
            return
        }
        for (payment in payments) {
            removePayment(payment)
        }
    }

    override fun getPaymentInfo(paymentId: Long) {
        val payment = getPaymentById(paymentId)
        if (payment != null) {
            println(payment.toString())
        }
    }

    override fun getPaymentInfo(payment: IOrderPayment) {
        println(payment.toString())
    }

    override fun getAllPaymentsInfo() {
        if (payments.isEmpty()) {
            println("Нет платежей.")
        } else {
            println("Информация о всех платежах:")
            for (payment in payments) {
                println("Платеж с ID ${payment.id}:")
                println("Сумма платежа: ${payment.amount}")
                println("Метод оплаты: ${payment.paymentMethod}")
                println("Дата и время: ${payment.timestamp}")
            }
        }
    }
}