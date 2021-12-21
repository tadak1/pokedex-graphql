package com.example.animegraphql

import platform.Foundation.NSUserDefaults
import platform.Foundation.setValue

actual class PreferencesManager {
    actual fun getBool(key: String): Boolean {
        return NSUserDefaults.standardUserDefaults().boolForKey(key)
    }

    actual fun setBool(key: String, value: Boolean) {
        return NSUserDefaults.standardUserDefaults().setBool(value, key)
    }

    actual fun getInt(key: String): Long {
        return NSUserDefaults.standardUserDefaults().integerForKey(key)
    }

    actual fun setInt(key: String, value: Long) {
        return NSUserDefaults.standardUserDefaults().setInteger(value, key)
    }

    actual fun getFloat(key: String): Float {
        return NSUserDefaults.standardUserDefaults().floatForKey(key)
    }

    actual fun setFloat(key: String, value: Float) {
        return NSUserDefaults.standardUserDefaults().setFloat(value, key)
    }

    actual fun getString(key: String): String? {
        return NSUserDefaults.standardUserDefaults().stringForKey(key)
    }

    actual fun setString(key: String, value: String) {
        return NSUserDefaults.standardUserDefaults().setValue(value, forKey =  key)
    }
}