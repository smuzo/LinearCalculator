package com.example.linearcalculator

import android.os.Bundle
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

        val charges = binding.costService.text.toString()
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


     private fun double(totalCo:Double) {
//         val formattedTip = NumberFormat.getCurrencyInstance().format(totalCo)
         binding.Result.text = getString(R.string.tip_amount, totalCo.toString())
     }

}
