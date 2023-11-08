package com.example.krnovember

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.krnovember.ui.theme.KRnovemberTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    private val visitors = mutableListOf<Visitor>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val nameText = findViewById<EditText>(R.id.nameText)
        val nameSecondText = findViewById<EditText>(R.id.nameSecondText)
        val weightText = findViewById<EditText>(R.id.weightText)
        val heightText = findViewById<EditText>(R.id.heghtText)
        val birthDateText = findViewById<EditText>(R.id.birthDateText)
        val buttonNext = findViewById<Button>(R.id.nextButton)
        val buttonAddNew = findViewById<Button>(R.id.addNewButton)
        buttonAddNew.setOnClickListener {
            val name = nameText.text.toString()
            val nameSecond = nameSecondText.text.toString()
            val weight = weightText.text.toString().toInt()
            val height = heightText.text.toString().toInt()
            val birthDate = birthDateText.text.toString()
            val visitor = Visitor(name, nameSecond, weight, height, birthDate)
            visitors.add(visitor)

            nameText.text.clear()
            nameSecondText.text.clear()
            weightText.text.clear()
            heightText.text.clear()
            birthDateText.text.clear()
        }
        buttonNext.setOnClickListener {
            val arr =  ArrayList<String>();
            for (visitor in visitors) {
                arr.add("${visitor.Name},${visitor.Name_second},${visitor.height},${visitor.weight},${visitor.birthDay}")
            }
            val intent = Intent(this, ViewActivity::class.java)
            intent.putStringArrayListExtra("visitors", arr)
            startActivity(intent)
        }
    }
}

