package com.jamiearellano.marvel.marvelapi

import com.squareup.moshi.JsonAdapter
import junit.framework.Assert.assertNotNull
import org.junit.Test

class AdapterFactoryTest {

    lateinit var adapter: JsonAdapter<Any>

    @Test
    fun getComicById_isAdapter_returnsTrue(){
        adapter = AdapterFactory().getComicById() as JsonAdapter<Any>
        assertNotNull(adapter)
    }

}
