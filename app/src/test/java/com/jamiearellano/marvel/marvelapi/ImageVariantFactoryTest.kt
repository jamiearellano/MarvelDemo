package com.jamiearellano.marvel.marvelapi

import com.jamiearellano.marvel.marvelapi.model.Variants
import org.junit.Assert.assertEquals
import org.junit.Test

class ImageVariantFactoryTest{
    var validUrl = "http://i.annihil.us/u/prod/marvel/i/mg/d/90/56c3909256053/standard_amazing.jpg"
    var validUrlPng = "http://i.annihil.us/u/prod/marvel/i/mg/d/90/56c3909256053/standard_amazing.png"
    var rootUrl = "http://i.annihil.us/u/prod/marvel/i/mg/d/90/56c3909256053"


    @Test
    fun getUrl_standardAmazing_equalToValidUrl(){
        var url = ImageVariantFactory().getUrl(rootUrl, ImageVariant.standard_amazing)
        assertEquals(url,validUrl)
        url = ImageVariantFactory("png").getUrl(rootUrl,ImageVariant.standard_amazing)
        assertEquals(url, validUrlPng)
    }
}