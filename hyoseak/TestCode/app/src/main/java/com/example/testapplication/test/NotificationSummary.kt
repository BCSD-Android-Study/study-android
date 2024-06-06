package com.example.testapplication.test

import android.content.Context
import com.example.testapplication.R

class NotificationSummary() {
    fun printNotificationSummary(numberOfMessages: Int) {
       if(numberOfMessages > 100){
           print("Your phone is blowing up! You have 99+ notifications.")
       }
       else{
           print("You have $numberOfMessages notifications.")
       }

    }
}