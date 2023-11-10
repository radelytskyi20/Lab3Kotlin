import java.lang.Exception

interface IDish {
    val name: String
    val description: String
    val ingredients: List<IIngredient>
}

class Dish : IDish {

    constructor(_name: String, _description: String, _ingridient: IIngredient) :
            this(_name, _description, listOf(_ingridient))

    constructor(_name: String, _description: String, _ingredients: List<IIngredient>){
        if (_name.isEmpty() || _description.isBlank() || !_ingredients.any())
            throw Exception(ErrorMessages.INCORRECT_DATA_MESSAGE)

        name = _name
        description = _description
        ingredients = _ingredients
    }

    override var name: String
        private set

    override var description: String
        private set

    override var ingredients: List<IIngredient>
        private set

    override fun toString(): String {
        val ingredientList = ingredients.joinToString { it.toString() }
        return "Dish(name='$name', description='$description', ingredients=[$ingredientList])"
    }

}

