package com.jamiearellano.marvel.marvelapi

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.moshi.JsonAdapter
import java.sql.Timestamp
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

private const val ROOT_URL = "https://gateway.marvel.com:443/v1/public"

class HttpFactory(context:Context) {

    private val queue = Volley.newRequestQueue(context)

    suspend fun get(requestEndPoint:String, jsonAdapter: JsonAdapter<Any>) = suspendCoroutine<Any> { continuation ->

        val ts = Timestamp(System.currentTimeMillis()).time.toString()
        val url = "$ROOT_URL/$requestEndPoint?${getAuth(ts)}"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                continuation.resume(parseResponse(response, jsonAdapter) as Any)
            },
            { error ->
                continuation.resume("Error: ${error.message}" as Any)
            })
        queue.add(stringRequest)
    }
}