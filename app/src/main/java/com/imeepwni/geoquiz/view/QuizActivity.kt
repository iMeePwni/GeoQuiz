package com.imeepwni.geoquiz.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.imeepwni.geoquiz.R
import com.imeepwni.geoquiz.model.data.Question
import com.imeepwni.geoquiz.model.respository.QuestionRespository

class QuizActivity : AppCompatActivity() {

    lateinit var currentQuestion: Question

    override fun onStart() {
        super.onStart()
        currentQuestion = QuestionRespository.currentQuestion()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
    }

    @Suppress("UNUSED_PARAMETER")
    fun showResult(view: View) {
        val resId =
                if (currentQuestion.answerTrue)
                    R.string.correct_toast
                else
                    R.string.incorrect_toast
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }

    @Suppress("UNUSED_PARAMETER")
    fun nextQuestion(view: View) {
        QuestionRespository.currentIndex++
        currentQuestion = QuestionRespository.currentQuestion()
    }
}
