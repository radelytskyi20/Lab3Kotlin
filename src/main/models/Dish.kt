import java.lang.Exception

interface IDish {
    val name: String
    val description: String
}

class Dish(_name: String, _description: String) : IDish {
    override var name: String
        private set

    override var description: String
        private set
    init {
        if (_name.isEmpty() || _description.isBlank())
            throw Exception("Incorrect data")

        name = _name
        description = _description
    }
}

