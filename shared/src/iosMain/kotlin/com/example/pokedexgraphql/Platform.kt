package com.example.pokedexgraphql

import com.apollographql.apollo3.ApolloClient
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual class PokemonClient actual constructor() {
    private val client = ApolloClient.Builder()
        .serverUrl("[ENDPOINT]")
        .build()

    actual suspend fun getPokemons(): List<GetPokemonsQuery.Pokemon?>? {
        return client.query(GetPokemonsQuery(first = 5)).execute().data?.pokemons
    }
}