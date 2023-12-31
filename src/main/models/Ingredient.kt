import java.lang.Exception
class Ingredient(_name: String, _quantity : Double, _unit: String) : IIngredient{
    override val name: String = _name
    override val quantity: Double = _quantity
    override val unit: String = _unit

    init {
        if (_name.isEmpty() || _quantity <= 0 || _unit.isEmpty())
            throw Exception(ErrorMessages.INCORRECT_DATA_MESSAGE)
    }
    override fun toString(): String {
        return "Ingredient(name='$name', quantity=$quantity, unit='$unit')"
    }

}