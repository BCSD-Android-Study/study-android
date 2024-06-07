package com.example.testapplication

import com.example.testapplication.test.Phone
import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class PhoneTest {
    @Test
    fun isScreenLightOn_switchOn_true() {
        val phone = Phone()
        phone.switchOn()
        Assert.assertTrue(phone.isScreenLightOn())
    }

    @Test
    fun isScreenLightOn_switchOff_false() {
        val phone = Phone()
        phone.switchOff()
        Assert.assertFalse(phone.isScreenLightOn())
    }

    @Test
    fun phone_switchOn_phoneScreenOn(){
        val phone = Phone()

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        phone.switchOn()
        phone.checkPhoneScreenLight()

        val expectedOutput = "The phone screen's light is on."
        Assert.assertEquals(expectedOutput, outputStream.toString())
    }

    @Test
    fun phone_switchOff_phoneScreenOff(){
        val phone = Phone()

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        phone.switchOn()
        phone.checkPhoneScreenLight()

        val expectedOutput = "The phone screen's light is on."
        Assert.assertEquals(expectedOutput, outputStream.toString())
    }
}