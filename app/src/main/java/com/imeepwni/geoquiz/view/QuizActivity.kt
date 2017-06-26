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

    override fun onStart() {
        super.onStart()
        nextQuestion(null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
    }

    fun showResult(view: View) {
        val resId =
                if ((currentQuestion.answerTrue && view.id == R.id.true_button)
                        || (!currentQuestion.answerTrue && view.id == R.id.false_button))
                    R.string.correct_toast
                else
                    R.string.incorrect_toast
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }

    fun prevQuestion(view: View) {
        currentQuestion = QuestionRepository.prevQuestion()
        question_text.text = getString(currentQuestion.textResId)
    }

    fun nextQuestion(view: View?) {
        currentQuestion = QuestionRepository.nextQuestion()
        question_text.text = getString(currentQuestion.textResId)
    }
}
