package com.example.testapplication.test

class Phone(private var isScreenLightOn: Boolean = false){
    fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun isScreenLightOn() = isScreenLightOn

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        print("The phone screen's light is $phoneScreenLight.")
    }
}