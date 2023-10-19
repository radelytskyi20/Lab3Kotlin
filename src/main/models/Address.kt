import java.lang.Exception

interface IAddress{
    val street: String
    val city: String
    //val postalCode: String
    //Additional details => mb add
}

class Address(_street: String, _city: String) : IAddress{
    override var street: String
        private set
    override var city: String
        private set

    init {

        if (_street.isEmpty() || _city.isEmpty())
            throw Exception(ErrorMessages.INCORRECT_DATA_MESSAGE)

        street = _street
        city = _city
    }
}