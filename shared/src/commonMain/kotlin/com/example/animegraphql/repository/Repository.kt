package com.example.animegraphql.repository

import org.koin.core.component.inject
import com.example.animegraphql.GetPagesQuery
import com.example.animegraphql.apollo.AnimeListClient
import com.example.animegraphql.apollo.AnimeListClientInterface
import org.koin.core.component.KoinComponent

interface MediaRepositoryInterface {
    suspend fun fetchMedia(): List<GetPagesQuery.Medium>?
}

class MediaRepository(
    private val animeListClient: AnimeListClientInterface
) : KoinComponent, MediaRepositoryInterface {
    override suspend fun fetchMedia(): List<GetPagesQuery.Medium>? {
        return animeListClient.getMediaPage()
    }
}