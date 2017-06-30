package com.imeepwni.geoquiz.view

import android.content.*
import android.os.*
import android.support.design.widget.*
import android.support.v7.app.*
import android.view.*
import com.imeepwni.geoquiz.*
import com.imeepwni.geoquiz.model.data.*
import com.imeepwni.geoquiz.model.respository.*
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlin.properties.*

@Suppress("UNUSED_PARAMETER")
class QuizActivity : AppCompatActivity() {

    var currentQuestion: Question by Delegates.observable(QuestionRepository.currentQuestion()) {
        _, _, _ ->
        refreshUI()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
    }

    override fun onResume() {
        super.onResume()
        refreshUI()
    }

    fun refreshUI() {
        question_text.text = getString(currentQuestion.textResId)
        true_button.isEnabled = !currentQuestion.isAnswered
        false_button.isEnabled = !currentQuestion.isAnswered
        if (currentQuestion.isCheated) {
            Snackbar.make(container, R.string.judgment_toast, Snackbar.LENGTH_SHORT).show()
        }
        if (QuestionRepository.isCompletedAllQuestion()) {
            Snackbar.make(container, QuestionRepository.score(), Snackbar.LENGTH_SHORT).show()
        }
    }

    fun showResult(view: View) {
        val myAnswer = view.id==R.id.true_button
        val isAnswerRight = currentQuestion.answerTrue==myAnswer
        QuestionRepository.completeQuestion(isAnswerRight)
        val resId = if (isAnswerRight) R.string.correct_toast else R.string.incorrect_toast
        Snackbar.make(container, resId, Snackbar.LENGTH_SHORT).show()
    }

    fun prevQuestion(view: View) {
        QuestionRepository.currentIndex--
        currentQuestion = QuestionRepository.currentQuestion()
    }

    fun nextQuestion(view: View) {
        QuestionRepository.currentIndex++
        currentQuestion = QuestionRepository.currentQuestion()
    }

    fun startCheatActivity(view: View) {
        startActivity(Intent(this, CheatActivity::class.java))
    }
}
