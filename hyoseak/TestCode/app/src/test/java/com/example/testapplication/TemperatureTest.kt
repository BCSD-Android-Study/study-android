package com.example.testapplication

import com.example.testapplication.test.Temperature
import org.junit.Test

import org.junit.Assert.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TemperatureTest {
    @Test
    fun celsius27_convertToFahrenheit_fahrenheit80Point60() {
        val temperature = Temperature()
        val initialMeasurement = 27.0
        val initialUnit = "Celsius"
        val finalUnit = "Fahrenheit"
        val conversionFormula = { celsius: Double -> celsius * 9/5 + 32 }

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        temperature.printFinalTemperature(initialMeasurement, initialUnit, finalUnit, conversionFormula)

        val expectedOutput = "27.0 degrees Celsius is 80.60 degrees Fahrenheit."
        assertEquals(expectedOutput, outputStream.toString())
    }

    @Test
    fun kelvin350_convertToCelsius_celsius76Point85() {
        val temperature = Temperature()
        val initialMeasurement = 350.0
        val initialUnit = "Kelvin"
        val finalUnit = "Celsius"
        val conversionFormula = { kelvin: Double -> kelvin - 273.15 }

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        temperature.printFinalTemperature(initialMeasurement, initialUnit, finalUnit, conversionFormula)

        val expectedOutput = "350.0 degrees Kelvin is 76.85 degrees Celsius."
        assertEquals(expectedOutput, outputStream.toString())
    }

    @Test
    fun fahrenheit10_convertToKelvin_kelvin260Point93() {
        val temperature = Temperature()
        val initialMeasurement = 10.0
        val initialUnit = "Fahrenheit"
        val finalUnit = "Kelvin"
        val conversionFormula = { fahrenheit: Double -> (fahrenheit - 32) * 5/9 + 273.15}

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        temperature.printFinalTemperature(initialMeasurement, initialUnit, finalUnit, conversionFormula)

        val expectedOutput = "10.0 degrees Fahrenheit is 260.93 degrees Kelvin."
        assertEquals(expectedOutput, outputStream.toString())
    }
}

