package com.example.radiobuttonviktorinaonhistory

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    private lateinit var scoreTV: TextView
    private lateinit var infoHistoryTV: TextView
    private lateinit var finishBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        scoreTV = findViewById(R.id.scoreTV)
        infoHistoryTV = findViewById(R.id.infoHistoryTV)
        finishBTN = findViewById(R.id.finishBTN)

        val scoreActivityPrevious = intent.getIntExtra("score", 0)

        scoreTV.text = "За каждый правильный ответ вы получали 100 баллов и заработали $scoreActivityPrevious баллов"
        when (scoreActivityPrevious) {
            100 -> infoHistoryTV.text = "Ваш уровень знаний можно оценить как - ПЛОХОЙ"
            200 -> infoHistoryTV.text = "Ваш уровень знаний можно оценить как - НЕУДОВЛЕТВОРИТЕЛЬНЫЙ"
            300 -> infoHistoryTV.text = "Ваш уровень знаний можно оценить как - УДОВЛЕТВОРИТЕЛЬНЫЙ"
            400 -> infoHistoryTV.text = "Ваш уровень знаний можно оценить как - ХОРОШИЙ"
            500 -> infoHistoryTV.text = "Ваш уровень знаний можно оценить как - ОТЛИЧНЫЙ"
            else -> infoHistoryTV.text = "Всё очень печально, возможно вам надо подучить историю!"
        }
        finishBTN.setOnClickListener { view ->
            finishAffinity()
        }
    }
}