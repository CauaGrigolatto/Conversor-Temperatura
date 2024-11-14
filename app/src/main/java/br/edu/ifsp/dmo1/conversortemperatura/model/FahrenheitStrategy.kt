package br.edu.ifsp.dmo1.conversortemperatura.model

class FahrenheitStrategy : TemperatureConverter {
    override fun convertToCelsius(t: Double): Double {
        return (t - 32) * 5/9
    }
    override fun convertToFahrenheit(t: Double): Double {
        return t
    }

    override fun convertToKelvin(t: Double): Double {
        return convertToCelsius(t) + 273.15
    }

    override fun getScale(): String {
        return "ºF"
    }
}