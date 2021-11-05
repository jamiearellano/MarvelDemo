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
class MainActivityInstrumentedTest {

    @Test
    fun launchActivity_verifyComicViewModelIsAvailable_returnsTrue() {
        val scenario = launchActivity<MainActivity>()
        scenario.onActivity { activity ->
            assertNotNull(activity.comicViewModel)
        }
    }
}

