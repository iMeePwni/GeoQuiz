package com.imeepwni.geoquiz.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.imeepwni.geoquiz.R
import com.imeepwni.geoquiz.model.data.Question
import com.imeepwni.geoquiz.model.respository.QuestionRepository
import kotlinx.android.synthetic.main.activity_quiz.*

@Suppress("UNUSED_PARAMETER")
class QuizActivity : AppCompatActivity() {

    lateinit var currentQuestion: Question

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        refreshUI()
    }

    fun refreshUI() {
        currentQuestion = QuestionRepository.currentQuestion()
        question_text.text = getString(currentQuestion.textResId)
    }

    fun showResult(view: View) {
        val myAnswer = view.id==R.id.true_button

        val resId =
                if ((currentQuestion.answerTrue==myAnswer))
                    R.string.correct_toast
                else
                    R.string.incorrect_toast
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }

    fun prevQuestion(view: View) {
        QuestionRepository.currentIndex--
        refreshUI()
    }

    fun nextQuestion(view: View?) {
        QuestionRepository.currentIndex++
        refreshUI()
    }
}
