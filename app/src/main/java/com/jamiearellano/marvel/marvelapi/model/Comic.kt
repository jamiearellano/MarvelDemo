package com.jamiearellano.marvel.marvelapi.model

import com.squareup.moshi.JsonClass

/**
 * Response Data class for /v1/public/comics/{comicId}
 */
@JsonClass(generateAdapter = true)
data class Comic(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: Data
)

@JsonClass(generateAdapter = true)
data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Results>
)

@JsonClass(generateAdapter = true)
data class Results(
    val id : String?,
    val digitalId : String?,
    val title : String?,
    val issueNumber : String?,
    val variantDescription : String?,
    val description : String?,
    val modified : String?,
    val isbn : String?,
    val upc : String?,
    val diamondCode : String?,
    val ean : String?,
    val issn : String?,
    val format : String?,
    val pageCount : String?,
    val textObjects : List<TextObjects>?,
    val resourceURI : String?,
    val urls : List<Urls>?,
    val series : Series?,
    val variants : List<Variants>?,
    val collections : List<Collections>?,
    val collectedIssues : List<CollectedIssues>?,
    val dates : List<Dates>?,
    val prices : List<Prices>?,
    val thumbnail : Thumbnail?,
    val images : List<Images>?,
    val creators : Creators?,
    val characters : Characters?,
    val stories : Stories?,
    val events : Events?
)

@JsonClass(generateAdapter = true)
data class TextObjects (

    val type : String?,
    val language : String?,
    val text : String?
)

@JsonClass(generateAdapter = true)
data class Urls (
    val type : String?,
    val url : String?
)

@JsonClass(generateAdapter = true)
data class Series (
    val resourceURI : String?,
    val name : String?
)

@JsonClass(generateAdapter = true)
data class Variants (
    val resourceURI : String?,
    val name : String?
)

@JsonClass(generateAdapter = true)
data class CollectedIssues (
    val resourceURI : String?,
    val name : String?
)

@JsonClass(generateAdapter = true)
data class Collections (
    val resourceURI : String?,
    val name : String?
)

@JsonClass(generateAdapter = true)
data class Dates (
    val type : String?,
    val date : String?
)

@JsonClass(generateAdapter = true)
data class Prices (
    val type : String?,
    val price : String?
)

@JsonClass(generateAdapter = true)
data class Thumbnail (
    val path : String?,
    val extension : String?
)

@JsonClass(generateAdapter = true)
data class Images (
    val path : String?,
    val extension : String?
)

@JsonClass(generateAdapter = true)
data class Creators (
    val available : String?,
    val returned : String?,
    val collectionURI : String?,
    val items : List<Items>?
)

@JsonClass(generateAdapter = true)
data class Characters (

    val available : String?,
    val returned : String?,
    val collectionURI : String?,
    val items : List<Items>?
)

@JsonClass(generateAdapter = true)
data class Stories (
    val available : String?,
    val returned : String?,
    val collectionURI : String?,
    val items : List<Items>?
)

@JsonClass(generateAdapter = true)
data class Events (
    val available : String?,
    val returned : String?,
    val collectionURI : String?,
    val items : List<Items>?
)

@JsonClass(generateAdapter = true)
data class Items (
    val resourceURI : String?,
    val name : String?
)