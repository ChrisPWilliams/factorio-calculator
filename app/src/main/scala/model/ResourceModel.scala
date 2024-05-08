package model

case class Recipe(
                 timeSeconds: Double,
                 itemYield: Int,
                 ingredients: Seq[Ingredient]
                 )

case class Ingredient(item: Item, quantity: Double)

sealed abstract class Item(recipe: Recipe)
object Item {

  case object ironOre extends Item(
    Recipe(
      timeSeconds = 0,
      itemYield = 1,
      ingredients = Seq.empty[Ingredient]
    )
  )
  case object ironPlate extends Item(
    Recipe(
      timeSeconds = 3.5,
      itemYield = 1,
      ingredients = Seq(
        Ingredient(
          ironOre, 1
        )
      )
    )
  )
}

//TODO: write extractor & formatter for https://kevinta893.github.io/factorio-recipes-json/recipes.min.json to save writing out by hand