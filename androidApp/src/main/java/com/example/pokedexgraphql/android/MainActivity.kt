package com.example.pokedexgraphql.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pokedexgraphql.Greeting
import android.widget.TextView
import com.example.pokedexgraphql.PokemonClient
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val result = PokemonClient().getPokemons()
            Log.d("pokemon", result!!)
        }

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }
}
