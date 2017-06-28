package com.imeepwni.geoquiz.view

import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.*
import android.support.test.rule.*
import android.support.test.runner.*
import com.imeepwni.geoquiz.R
import org.junit.*
import org.junit.runner.*

/**
 * Create by guofeng on 2017/6/28.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class QuizActivityTest {

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<QuizActivity>(QuizActivity::class.java)

    @Test
    fun prevQuestion() {
        onView(withId(R.id.false_button)).perform(click())
    }

    @Test
    fun nextQuestion() {
        onView(withId(R.id.false_button)).perform(click())
    }

}