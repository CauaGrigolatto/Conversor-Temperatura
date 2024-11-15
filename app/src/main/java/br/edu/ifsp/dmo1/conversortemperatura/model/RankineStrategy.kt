package br.edu.ifsp.dmo1.conversortemperatura.model

class RankineStrategy : TemperatureConverter {
    override fun convertToCelsius(t: Double): Double {
        return t * 5/9 - 273.15
    }

    override fun convertToFahrenheit(t: Double): Double {
        return t - 459.67
    }

    override fun convertToKelvin(t: Double): Double {
        return t * 5/9
    }

    override fun convertToRankine(t: Double): Double {
        return t
    }

    override fun getScale(): String {
        return "ºR"
    }

}