package com.example.animegraphql.android

import android.app.Application
import com.example.animegraphql.apollo.AnimeListClient
import com.example.animegraphql.apollo.AnimeListClientInterface
import com.example.animegraphql.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import org.koin.dsl.scoped

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MainApplication)
        }
    }
}