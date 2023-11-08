package com.example.krnovember

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.ComponentActivity
import java.time.LocalDate;
import java.time.Period
import java.time.format.DateTimeFormatter



fun getAge(date_birth: String): Int {
    return Period.between(
        LocalDate.parse(date_birth),
        LocalDate.now()
    ).years
}


class ViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_activity)
        val visitors = intent.getStringArrayListExtra("visitors")
        val vis_tgt = mutableListOf<String>()
        val vis_tgt_first = mutableListOf<String>()
        val vis_tgt_second = mutableListOf<String>()
        if (visitors != null) {
            for (visitor in visitors) {
                vis_tgt.add(visitor)
                val buffArray: List<String> = visitor.split(",")

                vis_tgt_first.add("${buffArray[0]}, ${buffArray[1]}, ${getAge(buffArray[4])}")
                vis_tgt_second.add("${buffArray[0]}, ${buffArray[1]}, ${buffArray[3]}")
            }
        }
        val buttonAll = findViewById<Button>(R.id.fulinfbutton)
        val buttonModeFirst = findViewById<Button>(R.id.modeFirstButton)
        val buttonModeSecond = findViewById<Button>(R.id.modeSecondButton)
        val tgtListView = findViewById<ListView>(R.id.resListView)
        val fullarrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, vis_tgt
        )
        val modeFirstarrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, vis_tgt_first
        )
        val modeSecondarrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, vis_tgt_second
        )
        buttonAll.setOnClickListener {
            tgtListView.adapter = fullarrayAdapter
        }
        buttonModeFirst.setOnClickListener {
            tgtListView.adapter = modeFirstarrayAdapter
        }
        buttonModeSecond.setOnClickListener {
            tgtListView.adapter = modeSecondarrayAdapter
        }


    }
}

