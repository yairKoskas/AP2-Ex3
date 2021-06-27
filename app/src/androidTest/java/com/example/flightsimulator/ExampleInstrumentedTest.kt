package com.example.flightsimulator

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
<<<<<<< HEAD
        assertEquals("com.example.flightsimulator", appContext.packageName)
=======
        assertEquals("com.example.test", appContext.packageName)
>>>>>>> 59069e2416d8e0b3a37297cfa8ec714f0eaf7745
    }
}