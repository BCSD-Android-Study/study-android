package com.example.testapplication.test

class Temperature {
    fun printFinalTemperature(
        initialMeasurement: Double,
        initialUnit: String,
        finalUnit: String,
        conversionFormula: (Double) -> Double
    ) {
        val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
        print("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
    }
}