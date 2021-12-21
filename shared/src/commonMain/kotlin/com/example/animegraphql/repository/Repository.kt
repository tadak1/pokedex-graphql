package com.example.animegraphql.repository

import com.example.animegraphql.GetPagesQuery
import com.example.animegraphql.apollo.AnimeListClient

class Repository constructor(
    private val animeListClient: AnimeListClient
) {

    suspend fun fetchMedia(): List<GetPagesQuery.Medium>? {
        return animeListClient.getMediaPage()
    }

}