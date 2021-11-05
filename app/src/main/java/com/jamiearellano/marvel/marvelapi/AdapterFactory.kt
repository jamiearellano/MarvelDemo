package com.jamiearellano.marvel.marvelapi

import com.jamiearellano.marvel.marvelapi.model.Comic
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class AdapterFactory {
    val moshi: Moshi = Moshi.Builder()
        .build()

    fun getComicById() : JsonAdapter<Comic>{
        return moshi.adapter(Comic::class.java).lenient()
    }
}