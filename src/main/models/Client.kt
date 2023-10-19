import java.lang.Exception

interface IClient{
    val name: String
    val phoneNumber: String
    val address: Address
}

class Client(_name: String, _phoneNumber: String, _address: Address) : IClient{
    override var name: String
        private set
    override var phoneNumber: String
        private set
    override var address: Address
        private set

    init {
        if (_name.isEmpty() || _phoneNumber.isEmpty())
            throw Exception("Incorrect data")

        name = _name
        phoneNumber = _phoneNumber
        address = _address
    }
}