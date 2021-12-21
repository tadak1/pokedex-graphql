package com.example.animegraphql.apollo

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.example.animegraphql.GetPagesQuery

class AnimeListClient {

    private val cacheFactory = MemoryCacheFactory(maxSizeBytes = 10 * 1024 * 1024)

    private val client = ApolloClient
        .Builder()
        .serverUrl("https://graphql.anilist.co/")
        .normalizedCache(cacheFactory)
        .build()



    @Throws(Exception::class)
    suspend fun getMediaPage(): List<GetPagesQuery.Medium>? {
        val response = client.query(GetPagesQuery()).execute()
        return response.data?.let {
            return it.page?.mediaFilterNotNull()
        }
    }
}