import java.lang.Exception

interface IClient{
    val name: String
    val phoneNumber: String
}

class Client(_name: String, _phoneNumber: String) : IClient{
    override var name: String
        private set
    override var phoneNumber: String
        private set

    init {
        if (_name.isEmpty() || _phoneNumber.isEmpty())
            throw Exception(ErrorMessages.INCORRECT_DATA_MESSAGE)

        name = _name
        phoneNumber = _phoneNumber
    }
}