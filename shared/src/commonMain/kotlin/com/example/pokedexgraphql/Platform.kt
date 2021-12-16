package com.example.pokedexgraphql

expect class Platform() {
    val platform: String
}


expect class PokemonClient() {
    suspend fun getPokemons(): List<GetPokemonsQuery.Pokemon?>?
}