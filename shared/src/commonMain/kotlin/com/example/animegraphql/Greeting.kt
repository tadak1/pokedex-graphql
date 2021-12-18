package com.example.animegraphql

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}