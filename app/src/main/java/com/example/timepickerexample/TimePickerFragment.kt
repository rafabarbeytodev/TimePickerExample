package com.example.timepickerexample

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

/*****
 * Proyect: TimePickerExample
 * Package: com.example.timepickerexample
 *
 * Created by Rafael Barbeyto Torrellas on 21/02/2023 at 11:15
 * More info: https://www.linkedin.com/in/rafa-barbeyto/
 *
 * All rights reserved 2023.
 *****/
class TimePickerFragment(val listener: (String) -> Unit): DialogFragment(),
    TimePickerDialog.OnTimeSetListener{

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        listener("$hourOfDay : $minute")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val cal = Calendar.getInstance()
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        val minute = cal.get(Calendar.MINUTE)
        val dialog = TimePickerDialog(activity as Context,this, hour, minute,true)
        return dialog
    }
}