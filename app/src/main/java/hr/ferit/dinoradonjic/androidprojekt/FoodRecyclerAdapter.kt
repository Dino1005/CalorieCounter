package hr.ferit.dinoradonjic.androidprojekt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodRecyclerAdapter(private val items: ArrayList<Food>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        return FoodViewHolder(

            LayoutInflater.from(parent.context).inflate(R.layout.item, parent,
                false)
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,
                                  position: Int) {
        when(holder) {
            is FoodViewHolder -> {
                holder.bind(items[position])
            }
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class FoodViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        private val name: TextView =
            itemView.findViewById(R.id.itemName)
        private val sugar: TextView =
            itemView.findViewById(R.id.sugar)
        private val fiber: TextView =
            itemView.findViewById(R.id.fiber)
        private val sodium: TextView =
            itemView.findViewById(R.id.sodium)
        private val potassium: TextView =
            itemView.findViewById(R.id.potassium)
        private val fat: TextView =
            itemView.findViewById(R.id.fat)
        private val calories: TextView =
            itemView.findViewById(R.id.calories)
        private val carbohydrates: TextView =
            itemView.findViewById(R.id.carbohydrates)
        private val protein: TextView =
            itemView.findViewById(R.id.protein)
        private val size: TextView =
            itemView.findViewById(R.id.size)

        fun bind(food: Food) {
            name.text = food.name
            sugar.text = food.sugar_g.toString()
            fiber.text = food.fiber_g.toString()
            sodium.text = food.sodium_mg.toString()
            potassium.text = food.potassium_mg.toString()
            fat.text = food.fat_total_g.toString()
            calories.text = food.calories.toString()
            carbohydrates.text = food.carbohydrates_total_g.toString()
            protein.text = food.protein_g.toString()
            size.text = food.serving_size_g.toString()
        }
    }
}
