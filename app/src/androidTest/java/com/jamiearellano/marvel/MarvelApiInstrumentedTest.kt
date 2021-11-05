package com.jamiearellano.marvel

import android.content.Context
import androidx.test.core.app.launchActivity
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jamiearellano.marvel.marvelapi.model.Comic
import com.jamiearellano.marvel.marvelapi.*
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MarvelApiInstrumentedTest {

    val wolverineNullDescription = "85505"
    val venomWithDescription = "64570"
    val venomWithHtmlTagsInDescription = "40651"
    lateinit var appContext:Context
    lateinit var repository:MarvelRepository

    @Before
    fun verifyAppContext(){
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.jamiearellano.marvel", appContext.packageName)
    }

    @Before
    fun verifyMarvelRepository(){
        repository = MarvelRepository(appContext)
        assertNotNull(repository)
    }

    @Test
    fun fetchComicById_withNullDescription_returnsTrue(){
        val result = runBlocking {  repository.fetchComicById(wolverineNullDescription) }
        assertNotNull(result)
        assert(result is Comic)
        if (result != null) {
            assertNotNull(result.data)
            assertNotNull(result.data.results)
            assertNotNull(result.data.results[0])
            assertNotNull(result.data.results[0].title)
            assertNull(result.data.results[0].description)
            assertNotNull(result.data.results[0].title)
            assertNotNull(result.data.results[0].thumbnail)
        }
    }

    @Test
    fun fetchComicById_withDescription_returnsTrue(){
        val result = runBlocking {  repository.fetchComicById(venomWithDescription) }
        assertNotNull(result)
        assert(result is Comic)
        if (result != null) {
            assertNotNull(result.data)
            assertNotNull(result.data.results)
            assertNotNull(result.data.results[0])
            assertNotNull(result.data.results[0].title)
            assertNotNull(result.data.results[0].description)
            assertNotNull(result.data.results[0].title)
            assertNotNull(result.data.results[0].thumbnail)
        }
    }

    @Test
    fun fetchComicById_htmlTagsInDescription_returnsTrue(){
        val result = runBlocking {  repository.fetchComicById(venomWithHtmlTagsInDescription) }
        assertNotNull(result)
        assert(result is Comic)
        if (result != null) {
            assertNotNull(result.data)
            assertNotNull(result.data.results)
            assertNotNull(result.data.results[0])
            assertNotNull(result.data.results[0].title)
            assertNotNull(result.data.results[0].description)
            assertNotNull(result.data.results[0].title)
            assertNotNull(result.data.results[0].thumbnail)
        }
    }

}

