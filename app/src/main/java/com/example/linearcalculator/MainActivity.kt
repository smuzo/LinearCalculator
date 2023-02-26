package com.example.linearcalculator

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodManager.HIDE_IMPLICIT_ONLY
import androidx.appcompat.app.AppCompatActivity
import com.example.linearcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculate.setOnClickListener { calculator() }
    }

    private fun calculator() {

        val charges = binding.costOfService.text.toString()
        val cost = charges.toDoubleOrNull()

        if (cost == null || cost == 0.0) {
            double(0.0)
            return
        }
        val percentage = when (binding.tipOption.checkedRadioButtonId) {
            R.id.twentyPercent -> 0.20
            R.id.eighteenPercent -> 0.18
            else
            -> 0.15
        }
        var totalCo = percentage * cost

        if (binding.switchButton.isChecked) {
            totalCo = kotlin.math.ceil(totalCo)
        }
        double(totalCo)
    }


    private fun double(totalCo: Double) {
//         val formattedTip = NumberFormat.getCurrencyInstance().format(totalCo)
        binding.Result.text = getString(R.string.tip_amount, totalCo.toString())
    }
    private fun handleKeyEvent(view: View, keyCode:Int):Boolean{
        if(keyCode == KeyEvent.KEYCODE_ENTER){

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)

            return true
        }
        return false
    }

}
