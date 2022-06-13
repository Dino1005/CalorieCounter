package hr.ferit.dinoradonjic.androidprojekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editName = findViewById<EditText>(R.id.editName)
        val editHeight = findViewById<EditText>(R.id.editHeight)
        val editWeight = findViewById<EditText>(R.id.editWeight)
        val startButton = findViewById<Button>(R.id.startButton)
        val radio = findViewById<RadioGroup>(R.id.radioGroup)


        startButton.setOnClickListener{
            val x = if(radio.checkedRadioButtonId == 2131231236) 1.3
            else 0.0
            if(!(editHeight.text.toString().isEmpty() || editWeight.text.toString().isEmpty() || editName.text.toString().isEmpty())) {
                Intent(this, SecondActivity()::class.java).also {
                    it.putExtra("Name", editName.text.toString())
                    it.putExtra("Calories",
                        (editWeight.text.toString().toDouble() * 10 + editHeight.text.toString()
                            .toDouble() * 6.25 + editWeight.text.toString()
                            .toDouble() * x).toString()
                    )
                    startActivity(it)
                }
            }
        }

    }


}