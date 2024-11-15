package br.edu.ifsp.dmo1.conversortemperatura.model

interface TemperatureConverter {
    companion object {
        const val CELSIUS = "Celsius"
        const val FAHRENHEIT = "Fahrenheit"
        const val KELVIN = "Kelvin"
    }

    fun convertToCelsius(t: Double): Double
    fun convertToFahrenheit(t: Double): Double
    fun convertToKelvin(t: Double): Double
    fun getScale(): String
}