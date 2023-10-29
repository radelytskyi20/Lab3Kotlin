import java.lang.Exception

interface IIngredient{
    val name: String
    val quantity: Double
    val unit: String
}

class Ingredient(_name: String, _quantity : Double, _unit: String) : IIngredient{
    override var name: String
        private set
    override var quantity: Double
        private set
    override var unit: String
        private set

    init {
        if (_name.isEmpty() || _quantity <= 0 || _unit.isEmpty())
            throw Exception(ErrorMessages.INCORRECT_DATA_MESSAGE)

        name = _name
        quantity = _quantity
        unit = _unit
    }
}