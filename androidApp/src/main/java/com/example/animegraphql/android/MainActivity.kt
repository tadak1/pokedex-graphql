package com.example.animegraphql.android

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.animegraphql.PreferencesManager
import com.example.animegraphql.apollo.AnimeListClient
import com.example.animegraphql.android.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main))
        GlobalScope.launch {
            val result = AnimeListClient().getMediaPage()
            Log.d("pokemon", result!!.toString())
        }
    }
}
