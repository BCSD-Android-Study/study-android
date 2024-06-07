package com.example.testapplication

import com.example.testapplication.test.NotificationSummary
import com.example.testapplication.test.Phone
import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class NotificationTest {
    @Test
    fun num50_Notification_print50Notification() {
        val notificationSummary = NotificationSummary()
        val numOfNotification = 50

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))


        notificationSummary.printNotificationSummary(numOfNotification)

        val expectedOutput = "You have 50 notifications."
        Assert.assertEquals(expectedOutput, outputStream.toString())
    }

    @Test
    fun num200_Notification_print99PlusNotification() {
        val notificationSummary = NotificationSummary()
        val numOfNotification = 200

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))


        notificationSummary.printNotificationSummary(numOfNotification)

        val expectedOutput = "Your phone is blowing up! You have 99+ notifications."
        Assert.assertEquals(expectedOutput, outputStream.toString())
    }
}