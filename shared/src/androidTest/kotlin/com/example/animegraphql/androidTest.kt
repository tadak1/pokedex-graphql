package com.example.animegraphql

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidSharedPreferenceTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", SharedPreference().greeting().contains("Android"))
    }
}