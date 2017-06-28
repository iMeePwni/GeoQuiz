package com.imeepwni.geoquiz.view

import android.os.*
import android.support.v7.app.*
import android.view.*
import android.widget.*
import com.imeepwni.geoquiz.*
import com.imeepwni.geoquiz.model.data.*
import com.imeepwni.geoquiz.model.respository.*
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
        true_button.isEnabled = !currentQuestion.isAnswered
        false_button.isEnabled = !currentQuestion.isAnswered

        if (QuestionRepository.isCompletedAllQuestion()) {
            Toast.makeText(this, QuestionRepository.score(), Toast.LENGTH_SHORT).show()
        }
    }

    fun showResult(view: View) {
        val myAnswer = view.id==R.id.true_button
        val isAnswerRight = currentQuestion.answerTrue==myAnswer
        QuestionRepository.completeQuestion(isAnswerRight)
        val resId = if (isAnswerRight) R.string.correct_toast else R.string.incorrect_toast
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
