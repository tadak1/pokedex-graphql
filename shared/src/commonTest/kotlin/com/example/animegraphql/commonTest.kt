package com.example.animegraphql

import kotlin.test.Test
import kotlin.test.assertTrue

class CommonSharedPreferenceTest {

    @Test
    fun testExample() {
        assertTrue(SharedPreference().greeting().contains("Hello"), "Check 'Hello' is mentioned")
    }
}