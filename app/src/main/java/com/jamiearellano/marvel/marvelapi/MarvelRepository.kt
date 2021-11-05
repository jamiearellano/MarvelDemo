package com.jamiearellano.marvel.marvelapi

import android.content.Context
import com.jamiearellano.marvel.marvelapi.model.Comic

class MarvelRepository (context:Context){

    private val api = HttpFactory(context)
    private val service = MarvelService(api)

    // TODO: HANDLE ERRORS - NO NETWORK CONNECTION - AND GENERAL NETWORK FAILURES
    suspend fun fetchComicById(id:String = "85505"): Comic? {
        val response = service.fetchComicById(id)
        return if (response is Comic){
            response
        } else null
    }
}