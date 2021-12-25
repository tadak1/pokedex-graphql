package com.example.animegraphql.android

import android.os.Bundle
import android.util.Log
import com.example.animegraphql.repository.MediaRepositoryInterface
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.ScopeActivity


class MainActivity : ScopeActivity() {
    private val mediaRepository: MediaRepositoryInterface by inject()

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val result = mediaRepository.fetchMedia()
            result?.forEach {
                Log.d("media", it.title.toString())
            }
        }
    }
}
