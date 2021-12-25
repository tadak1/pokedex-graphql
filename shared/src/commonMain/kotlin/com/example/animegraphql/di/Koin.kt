package com.example.animegraphql.di

import com.example.animegraphql.apollo.AnimeListClient
import com.example.animegraphql.apollo.AnimeListClientInterface
import com.example.animegraphql.apollo.createApolloClient
import com.example.animegraphql.repository.MediaRepository
import com.example.animegraphql.repository.MediaRepositoryInterface
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule())
}

fun commonModule() = module {
    single {
        createApolloClient()
    }
    single<AnimeListClientInterface> {
        AnimeListClient(get())
    }
    single<MediaRepositoryInterface> {
        MediaRepository(get())
    }
}