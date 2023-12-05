package com.example.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TextView
import com.example.countdowntimer.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nowTime = findViewById<TextView>(R.id.tvNowtime)

        val time = object : CountDownTimer(1000, 1000) {
            override fun onTick(nullisUntilFinished: Long) {
                nowTime.text = getCurrentDate()
            }

            override fun onFinish() {
                this.start()
            }
        }

        time.start()


        val numberPicker: NumberPicker = findViewById(R.id.numberPicker)

        numberPicker.minValue = 0
        numberPicker.maxValue = 23
        numberPicker.wrapSelectorWheel = false

        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
        }


        val numberPicker2: NumberPicker = findViewById(R.id.numberPicker2)
        numberPicker2.minValue = 0
        numberPicker2.maxValue = 59
        numberPicker2.wrapSelectorWheel = false

        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
        }


        binding.apply {
            bStart.setOnClickListener{
                startCountDownTimer(20000)
            }


        }
    }

fun getCurrentDate (): String {
    val sdf = SimpleDateFormat("HH:mm:ss")
    return sdf.format(Date())
}

    private fun startCountDownTimer(timeMillis: Long){
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1000){
            override fun onTick(timeM: Long){
                binding.tvTimer.text = timeM.toString()

            }

            override fun onFinish() {
                binding.tvTimer.text = "Finish"

            }


        }.start()

    }

}