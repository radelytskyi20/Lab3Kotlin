import java.lang.Exception
class Client(_name: String, _phoneNumber: String) : IClient{
    override val name: String
    override val phoneNumber: String

    init {
        if (_name.isEmpty() || _phoneNumber.isEmpty())
            throw Exception(ErrorMessages.INCORRECT_DATA_MESSAGE)

        name = _name
        phoneNumber = _phoneNumber
    }
    override fun toString(): String {
        return "Client(name='$name', phoneNumber='$phoneNumber')"
    }
}