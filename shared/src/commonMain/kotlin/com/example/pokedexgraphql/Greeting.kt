package com.example.pokedexgraphql

import com.apollographql.apollo3.ApolloClient

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}

class PokemonClient {
    val client = ApolloClient.Builder()
        .serverUrl("ENDPOINT")
        .build()

    suspend fun getPokemons(): String? {
        val response = client.query(GetPokemonsQuery(first = 5)).execute()
        return response.data?.pokemons?.get(0)?.name
    }
}