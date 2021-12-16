package com.example.pokedexgraphql

import com.apollographql.apollo3.ApolloClient

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}