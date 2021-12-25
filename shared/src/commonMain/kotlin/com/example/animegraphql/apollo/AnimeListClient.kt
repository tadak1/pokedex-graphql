package com.example.animegraphql.apollo

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.example.animegraphql.GetPagesQuery
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface AnimeListClientInterface {
    @Throws(Exception::class)
    suspend fun getMediaPage(): List<GetPagesQuery.Medium>?
}

fun createApolloClient(): ApolloClient {
    val cacheFactory = MemoryCacheFactory(maxSizeBytes = 10 * 1024 * 1024)

    return ApolloClient
        .Builder()
        .serverUrl("https://graphql.anilist.co/")
        .normalizedCache(cacheFactory)
        .build()
}

class AnimeListClient(private val client: ApolloClient) : KoinComponent,
    AnimeListClientInterface {

    @Throws(Exception::class)
    override suspend fun getMediaPage(): List<GetPagesQuery.Medium>? {
        val response = client.query(GetPagesQuery()).execute()
        return response.data?.let {
            return it.page?.mediaFilterNotNull()
        }
    }
}