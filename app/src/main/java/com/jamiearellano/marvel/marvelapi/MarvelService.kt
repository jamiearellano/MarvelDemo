package com.jamiearellano.marvel.marvelapi


import com.squareup.moshi.JsonAdapter

class MarvelService (val http: HttpFactory){

    @Suppress("UNCHECKED_CAST")
    suspend fun fetchComicById(comicId:String): Any{
         return http.get("comics/$comicId", AdapterFactory().getComicById() as JsonAdapter<Any>)
    }
}