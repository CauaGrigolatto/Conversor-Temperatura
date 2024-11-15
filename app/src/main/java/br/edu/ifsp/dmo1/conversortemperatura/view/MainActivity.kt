package br.edu.ifsp.dmo1.conversortemperatura.view

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.conversortemperatura.R
import br.edu.ifsp.dmo1.conversortemperatura.databinding.ActivityMainBinding
import br.edu.ifsp.dmo1.conversortemperatura.model.CelsiusStrategy
import br.edu.ifsp.dmo1.conversortemperatura.model.FahrenheitStrategy
import br.edu.ifsp.dmo1.conversortemperatura.model.KelvinStrategy
import br.edu.ifsp.dmo1.conversortemperatura.model.RankineStrategy
import br.edu.ifsp.dmo1.conversortemperatura.model.TemperatureConverter

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var converter: TemperatureConverter

    private lateinit var temperatureInput: EditText
    private lateinit var resultText: TextView
    private lateinit var fromTemperatureSpinner: Spinner
    private lateinit var toTemperatureSpinner: Spinner
    private lateinit var convertButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadComponents()
    }

    private fun loadComponents() {
        binding.root.setBackgroundResource(R.drawable.background_gradient)
        temperatureInput = binding.temperatureInput
        resultText = binding.resultTextView
        convertButton = binding.convertButton
        convertButton.setOnClickListener(this)
        loadSpinners()
    }

    private fun loadSpinners() {
        fromTemperatureSpinner = binding.fromTemperatureSpinner
        toTemperatureSpinner = binding.toTemperatureSpinner
        loadSpinnersTemperatureScales()
    }

    private fun loadSpinnersTemperatureScales() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.temperature_scales,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fromTemperatureSpinner.adapter = adapter
        toTemperatureSpinner.adapter = adapter
    }

    override fun onClick(v: View?) {
        if (v == convertButton) {
            convertAndDisplay()
        }
    }

    private fun convertAndDisplay() {
        try {
            var fromScale: String = getFromScale()
            var toScale: String = getToScale()

            var value: Double = getInputtedTemperature()

            this.converter = getConverter(fromScale)

            var result: Double = convert(value, toScale, converter)
            var formatScale: String = getFormatScale(toScale)

            displayResult(result, formatScale)
        }
        catch(e: IllegalArgumentException) {
            Toast.makeText(
                this,
                R.string.messsage_conversion_error,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun getFromScale(): String {
        return fromTemperatureSpinner.selectedItem.toString()
    }

    private fun getToScale(): String {
        return toTemperatureSpinner.selectedItem.toString()
    }

    private fun getInputtedTemperature(): Double {
        return try {
            temperatureInput.text.toString().toDouble()
        }
        catch (e: NumberFormatException) {
            0.0
        }
    }

    private fun getConverter(fromScale: String): TemperatureConverter {
        return when (fromScale) {
            TemperatureConverter.CELSIUS -> CelsiusStrategy()
            TemperatureConverter.FAHRENHEIT -> FahrenheitStrategy()
            TemperatureConverter.KELVIN -> KelvinStrategy()
            TemperatureConverter.RANKINE -> RankineStrategy()
            else -> throw IllegalArgumentException()
        }
    }

    private fun convert(value: Double, scale: String, converter: TemperatureConverter): Double {
        return when (scale) {
            TemperatureConverter.CELSIUS -> converter.convertToCelsius(value)
            TemperatureConverter.FAHRENHEIT -> converter.convertToFahrenheit(value)
            TemperatureConverter.KELVIN -> converter.convertToKelvin(value)
            TemperatureConverter.RANKINE -> converter.convertToRankine(value)
            else -> throw IllegalArgumentException()
        }
    }

    private fun getFormatScale(scale: String): String {
        return when (scale) {
            TemperatureConverter.CELSIUS -> CelsiusStrategy().getScale()
            TemperatureConverter.FAHRENHEIT -> FahrenheitStrategy().getScale()
            TemperatureConverter.KELVIN -> KelvinStrategy().getScale()
            TemperatureConverter.RANKINE -> RankineStrategy().getScale()
            else -> throw IllegalArgumentException()
        }
    }

    private fun displayResult(result: Double, scale: String) {
        resultText.text = "${String.format("%.2f", result)} $scale"
    }
}