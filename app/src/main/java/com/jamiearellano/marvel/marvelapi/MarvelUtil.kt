package com.jamiearellano.marvel.marvelapi


import com.jamiearellano.marvel.BuildConfig
import com.squareup.moshi.JsonAdapter
import java.math.BigInteger
import java.security.MessageDigest



fun getAuth(ts:String) : String{
    val publicKey = BuildConfig.MARVEL_PUBLIC_KEY
    return "ts=$ts&apikey=$publicKey&hash=${getAuthString(ts)}"
}

fun getAuthString(ts:String) : String{

    val publicKey = BuildConfig.MARVEL_PUBLIC_KEY
    val privateKey = BuildConfig.MARVEL_PRIVATE_KEY

    val input = "$ts$privateKey$publicKey"
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
}

fun parseResponse(jsonString:String, jsonAdapter: JsonAdapter<Any>): Any?{
    return try {
        jsonAdapter.fromJson(jsonString)
    } catch (e:Exception){
        e
    }
}