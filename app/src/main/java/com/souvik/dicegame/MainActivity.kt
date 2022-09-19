package com.souvik.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hideSystemBars();

        val firstDice = findViewById<ImageView>(R.id.first_dice)
        val secondDice = findViewById<ImageView>(R.id.second_dice)

        val rollBtn = findViewById<Button>(R.id.btn_roll);

        rollBtn.setOnClickListener {
            roll(firstDice)
            roll(secondDice)
        }
    }

    private fun roll(view: ImageView) {

        val num = Random().nextInt(6) + 1

        val resDrawable = when (num) {
            1 -> R.drawable.dice1;
            2 -> R.drawable.dice2;
            3 -> R.drawable.dice3;
            4 -> R.drawable.dice4;
            5 -> R.drawable.dice5;
            6 -> R.drawable.dice6;
            else -> R.drawable.dice6;
        }

        view.setImageResource(resDrawable)
    }

    private fun hideSystemBars() {
        val windowInsetsController = ViewCompat.getWindowInsetsController(window.decorView) ?: return

        windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}