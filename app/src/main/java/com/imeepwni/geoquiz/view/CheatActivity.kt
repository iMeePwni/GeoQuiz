package com.imeepwni.geoquiz.view

import android.animation.*
import android.os.*
import android.support.annotation.*
import android.support.v7.app.*
import android.view.*
import com.imeepwni.geoquiz.*
import com.imeepwni.geoquiz.model.data.*
import com.imeepwni.geoquiz.model.respository.*
import kotlinx.android.synthetic.main.activity_cheat.*

class CheatActivity : AppCompatActivity() {

    val currentQuestion: Question by lazy {
        QuestionRepository.currentQuestion()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        if (savedInstanceState!=null) {
            answer_text_view.text = savedInstanceState.getString("text", "")
            show_answer_button.visibility = savedInstanceState.getInt("button", View.VISIBLE)
        }

        api_level_text_view.text = Build.VERSION.SDK_INT.toString()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.run {
            putString("text", answer_text_view.text.toString())
            putInt("button", show_answer_button.visibility)
        }
    }

    fun showAnswer(view: View) {
        QuestionRepository.cheatQuestion()
        answer_text_view.text = currentQuestion.answerTrue.toString()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            animator(view)
        else
            view.visibility = View.INVISIBLE
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun animator(view: View) {
        val radius = view.width
        val cx = radius / 2
        val cy = view.height / 2
        val circularReveal = ViewAnimationUtils.createCircularReveal(view, cx, cy, radius.toFloat(), 0.toFloat())
        circularReveal.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                view.visibility = View.INVISIBLE
            }
        })
        circularReveal.start()
    }
}
