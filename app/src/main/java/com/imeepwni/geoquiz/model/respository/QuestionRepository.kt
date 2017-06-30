package com.imeepwni.geoquiz.model.respository

import com.imeepwni.geoquiz.*
import com.imeepwni.geoquiz.model.data.*

object QuestionRepository {

    private val questions = mutableListOf(
            Question(R.string.question_australia, true),
            Question(R.string.question_oceans, true),
            Question(R.string.question_mideast, false),
            Question(R.string.question_africa, false),
            Question(R.string.question_americas, true),
            Question(R.string.question_asia, true)
    )

    var currentIndex = 0
    var cheatCount = 0

    fun currentQuestion() = questions[modCurrentIndex()]

    fun modCurrentIndex(): Int {
        while (currentIndex < 0) {
            currentIndex += questions.size
        }
        return currentIndex % questions.size
    }

    fun completeQuestion(isAnswerRight: Boolean) {
        val question = questions[modCurrentIndex()]
        question.run {
            isAnswered = true
            this.isAnswerRight = isAnswerRight
        }
        questions[modCurrentIndex()] = question
    }

    fun cheatQuestion() {
        val question = questions[modCurrentIndex()]
        question.isCheated = true
        questions[modCurrentIndex()] = question
        cheatCount++
    }

    fun isCompletedAllQuestion() = questions.filter { !it.isAnswered }.isEmpty()

    fun score() = (questions.filter { it.isAnswerRight ?: false }.size * 100 / questions.size).toString() + "%"
}