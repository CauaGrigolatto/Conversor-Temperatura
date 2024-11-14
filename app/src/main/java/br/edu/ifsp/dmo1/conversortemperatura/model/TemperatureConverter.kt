package br.edu.ifsp.dmo1.conversortemperatura.model

interface TemperatureConverter {
    fun convertToCelsius(t: Double): Double
    fun convertToFahrenheit(t: Double): Double
    fun convertToKelvin(t: Double): Double
    fun getScale(): String
}