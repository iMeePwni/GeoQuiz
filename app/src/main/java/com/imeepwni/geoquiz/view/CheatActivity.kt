package com.imeepwni.geoquiz.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import com.imeepwni.geoquiz.*
import com.imeepwni.geoquiz.model.data.*
import com.imeepwni.geoquiz.model.respository.*
import kotlinx.android.synthetic.main.activity_cheat.*

class CheatActivity : AppCompatActivity() {

    val currentQuestion : Question by lazy {
        QuestionRepository.currentQuestion()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        if (savedInstanceState != null) {
            answer_text_view.text = savedInstanceState.getString("text", "")
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putString("text", answer_text_view.text.toString())
    }

    @Suppress("UNUSED_PARAMETER")
    fun showAnswer(view: View) {
        answer_text_view.text = currentQuestion.answerTrue.toString()
        QuestionRepository.cheatQuestion()
    }
}
