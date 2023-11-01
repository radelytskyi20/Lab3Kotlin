import java.lang.Exception

interface IClient{
    val name: String
    val phoneNumber: String
}

class Client(_name: String, _phoneNumber: String) : IClient{
    override val name: String
    override val phoneNumber: String

    init {
        if (_name.isEmpty() || _phoneNumber.isEmpty())
            throw Exception(ErrorMessages.INCORRECT_DATA_MESSAGE)

        name = _name
        phoneNumber = _phoneNumber
    }
}