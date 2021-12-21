package com.example.animegraphql

expect class PreferencesManager {
    fun getBool(key: String): Boolean
    fun setBool(key: String, value: Boolean)
    fun getInt(key: String): Long
    fun setInt(key: String, value: Long)
    fun getFloat(key: String): Float
    fun setFloat(key: String, value: Float)
    fun getString(key: String): String?
    fun setString(key: String, value: String)
}