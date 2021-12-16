package com.example.pokedexgraphql

import com.apollographql.apollo3.ApolloClient

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual class PokemonClient actual constructor(){
    private val client = ApolloClient.Builder()
        .serverUrl("[ENDPOINT]")
        .build()

    actual suspend fun getPokemons(): List<GetPokemonsQuery.Pokemon?>? {
        val response = client.query(GetPokemonsQuery(first = 5)).execute()
        return response.data?.pokemons
    }
}