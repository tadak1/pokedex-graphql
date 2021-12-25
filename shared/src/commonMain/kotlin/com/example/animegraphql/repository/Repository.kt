package com.example.animegraphql.repository

import org.koin.core.component.inject
import com.example.animegraphql.GetPagesQuery
import com.example.animegraphql.apollo.AnimeListClient
import com.example.animegraphql.apollo.AnimeListClientInterface
import org.koin.core.component.KoinComponent

interface MediaRepositoryInterface {
    @Throws(Exception::class)
    suspend fun fetchMedia(): List<GetPagesQuery.Medium>?
}

class MediaRepository : KoinComponent, MediaRepositoryInterface {
    private val animeListClient: AnimeListClientInterface by inject()

    @Throws(Exception::class)
    override suspend fun fetchMedia(): List<GetPagesQuery.Medium>? {
        return animeListClient.getMediaPage()
    }
}