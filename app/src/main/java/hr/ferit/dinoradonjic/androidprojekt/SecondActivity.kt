package hr.ferit.dinoradonjic.androidprojekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("Name")
        val nameView = findViewById<TextView>(R.id.name)
        nameView.text=name

        val calories = "Suggested calories: " +(intent.getStringExtra("Calories"))
        val suggestedCalories = findViewById<TextView>(R.id.suggestedCalories)
        suggestedCalories.text=calories


        var query = ""
        val editQuery = findViewById<EditText>(R.id.query)
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener{
            query += editQuery.text.toString() + " "
            editQuery.text.clear()
        }


        val calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener{
            Intent(this, ThirdActivity()::class.java).also{
                it.putExtra("Query",query)
                startActivity(it)
            }
        }
    }

}