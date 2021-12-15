package com.example.pokedexgraphql

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}