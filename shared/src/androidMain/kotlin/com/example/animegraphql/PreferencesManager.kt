package com.example.animegraphql

import android.content.Context
import android.content.SharedPreferences

actual class PreferencesManager constructor(context: Context) {
    private val sharedPreference: SharedPreferences =
        context.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)

    actual fun getBool(key: String): Boolean {
        return sharedPreference.getBoolean(key, false)
    }

    actual fun setBool(key: String, value: Boolean) {
        sharedPreference
            .edit()
            .putBoolean(key, value)
            .apply()
    }

    actual fun getInt(key: String): Long {
        return sharedPreference
            .getLong(key, 0)
    }

    actual fun setInt(key: String, value: Long) {
        sharedPreference
            .edit()
            .putLong(key, value)
            .apply()
    }

    actual fun getFloat(key: String): Float {
        return sharedPreference.getFloat(key, 0f)
    }

    actual fun setFloat(key: String, value: Float) {
        sharedPreference.edit()
            .putFloat(key, value)
            .apply()
    }

    actual fun getString(key: String): String? {
        return sharedPreference.getString(key, "")
    }

    actual fun setString(key: String, value: String) {
        sharedPreference
            .edit()
            .putString(key, value)
            .apply()
    }
}