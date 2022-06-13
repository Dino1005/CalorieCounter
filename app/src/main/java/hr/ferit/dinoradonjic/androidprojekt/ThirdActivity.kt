package hr.ferit.dinoradonjic.androidprojekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val query = intent.getStringExtra("Query")

        val request =
            ServiceBuilder.buildService(ApiEndpoints::class.java)
        val call = request.getFood(query.toString())
        call.enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response:
            Response<ResponseData>
            ) {
                if(response.isSuccessful) {
                    findViewById<RecyclerView>(R.id.foodList).apply {
                        layoutManager =
                            LinearLayoutManager(this@ThirdActivity)
                        adapter =
                            FoodRecyclerAdapter(response.body()!!.items)
                    }
                    var total = 0.0
                    for (item in response.body()!!.items){
                        total += item.calories
                    }
                    val totalCalories = findViewById<TextView>(R.id.total)
                    totalCalories.text = String.format("%.2f", total)
                }
            }
            override fun onFailure(call: Call<ResponseData>, t: Throwable)
            {
                Log.d("FAIL", t.message.toString())
            }
        })


        val reset = findViewById<Button>(R.id.resetButton)
        reset.setOnClickListener{
            Intent(this, MainActivity()::class.java).also{
                startActivity(it)
            }
        }

    }
}