package com.example.animegraphql.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.animegraphql.SharedPreference
import android.widget.TextView
import com.example.animegraphql.ExampleAniListClient
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun greet(): String {
    return SharedPreference().greeting()
}

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val result = ExampleAniListClient().getMediaPage()
            Log.d("pokemon", result!!.toString())
        }

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }
}
