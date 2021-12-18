package com.example.pokedexgraphql

import com.apollographql.apollo3.ApolloClient

expect class Platform() {
    val platform: String
}

class ExampleAniListClient {
    private val client = ApolloClient.Builder()
        .serverUrl("https://graphql.anilist.co/")
        .build()

    @Throws(Exception::class)
    suspend fun getMediaPage(): List<GetPagesQuery.Medium>? {
        val response = client.query(GetPagesQuery()).execute()
        return response.data?.let {
            return it.page?.mediaFilterNotNull()
        }
    }
}
