package com.example.radiobuttonviktorinaonhistory

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FourActivity : AppCompatActivity() {

    private lateinit var otvet1RB: RadioButton
    private lateinit var otvet2RB: RadioButton
    private lateinit var otvet3RB: RadioButton
    private lateinit var otvet4RB: RadioButton
    private lateinit var resultAnswerTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_four)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        otvet1RB = findViewById(R.id.otvet1RB)
        otvet2RB = findViewById(R.id.otvet2RB)
        otvet3RB = findViewById(R.id.otvet3RB)
        otvet4RB = findViewById(R.id.otvet4RB)
        resultAnswerTV = findViewById(R.id.resultAnswerTV)

        var scoreActivityPrevious = intent.getIntExtra("score", 0)

        val radioButtonClickListener =
            View.OnClickListener { view ->
                val radioButton = view as RadioButton
                when (radioButton.id) {
                    R.id.otvet2RB -> {
                        val score = 100
                        resultAnswerTV.setBackgroundColor(Color.GREEN)
                        scoreActivityPrevious += score
                        val intent = Intent(this, FiveActivity::class.java)
                        intent.putExtra("score", scoreActivityPrevious)
                        startActivity(intent)
                        finish()
                    }
                    else -> {
                        resultAnswerTV.setBackgroundColor(Color.RED)
                        val intent = Intent(this, FiveActivity::class.java)
                        intent.putExtra("score", scoreActivityPrevious)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        otvet1RB.setOnClickListener(radioButtonClickListener)
        otvet2RB.setOnClickListener(radioButtonClickListener)
        otvet3RB.setOnClickListener(radioButtonClickListener)
        otvet4RB.setOnClickListener(radioButtonClickListener)
    }

}

