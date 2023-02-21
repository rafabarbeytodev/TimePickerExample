package com.example.timepickerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.timepickerexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.etTime.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment { time ->
            onTimeSelected(time)
        }
        timePicker.show(supportFragmentManager, "time")
    }

    private fun String.toEditable(): Editable =
        Editable.Factory.getInstance().newEditable(this)

    private fun onTimeSelected(time: String) {
        val text = "Time selected: $time"
        mBinding.etTime.text = text.toEditable()
    }
}