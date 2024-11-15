package br.edu.ifsp.dmo1.conversortemperatura.model

object CelsiusStrategy : TemperatureConverter {
    override fun convertToCelsius(t: Double): Double {
        return t
    }
    override fun convertToFahrenheit(t: Double): Double {
        return (t * 9/5) + 32
    }

    override fun convertToKelvin(t: Double): Double {
        return t + 273.15
    }

    override fun convertToRankine(t: Double): Double {
        return convertToKelvin(t) * 9/5
    }

    override fun getScale(): String {
        return "ºC"
    }
}