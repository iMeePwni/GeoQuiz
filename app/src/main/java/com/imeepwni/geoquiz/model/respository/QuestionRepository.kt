package com.imeepwni.geoquiz.model.respository

import com.imeepwni.geoquiz.R
import com.imeepwni.geoquiz.model.data.Question

/**
* Created by guofeng on 2017/6/24.
*/
object QuestionRepository {

    val questions = arrayListOf(
            Question(R.string.question_australia, true),
            Question(R.string.question_oceans, true),
            Question(R.string.question_mideast, false),
            Question(R.string.question_africa, false),
            Question(R.string.question_americas, true),
            Question(R.string.question_asia, true)
    )

    var currentIndex = -1

    fun nextQuestion() = questions[++currentIndex % questions.size]

    fun prevQuestion() : Question {
        if (currentIndex <= 0) {
            currentIndex += questions.size
        }
        return questions[--currentIndex % questions.size]
    }
}