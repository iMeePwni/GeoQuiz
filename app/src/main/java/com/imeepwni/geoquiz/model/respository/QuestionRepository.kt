package com.imeepwni.geoquiz.model.respository

import com.imeepwni.geoquiz.R
import com.imeepwni.geoquiz.model.data.Question

object QuestionRepository {

    val questions = arrayListOf(
            Question(R.string.question_australia, true),
            Question(R.string.question_oceans, true),
            Question(R.string.question_mideast, false),
            Question(R.string.question_africa, false),
            Question(R.string.question_americas, true),
            Question(R.string.question_asia, true)
    )

    var currentIndex = 0

    fun currentQuestion() = questions[currentIndex % questions.size]

    fun nextQuestion() = questions[++currentIndex % questions.size]

    fun prevQuestion(): Question {
        if (currentIndex <= 0) {
            currentIndex += questions.size
        }
        return questions[--currentIndex % questions.size]
    }
}