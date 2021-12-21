package com.example.animegraphql

import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() {
        assertTrue(PreferencesManager().greeting().contains("iOS"), "Check iOS is mentioned")
    }
}