package hr.ferit.dinoradonjic.androidprojekt

data class ResponseData(
    val items: ArrayList<Food>
)

data class Food(
    val sugar_g: Double,
    val fiber_g: Double,
    val serving_size_g: Double,
    val sodium_mg: Double,
    val name: String,
    val potassium_mg: Double,
    val fat_total_g: Double,
    val calories: Double,
    val protein_g: Double,
    val carbohydrates_total_g: Double
)
