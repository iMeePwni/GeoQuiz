package com.imeepwni.geoquiz.model.respository

import com.imeepwni.geoquiz.R
import com.imeepwni.geoquiz.model.Question

/**
 * Created by guofeng on 2017/6/24.
 */
object QuestionRespository {

    val questions = arrayListOf<Question>(
            Question(R.string.question_australia, true),
            Question(R.string.question_oceans, true),
            Question(R.string.question_mideast, false),
            Question(R.string.question_africa, false),
            Question(R.string.question_americas, true),
            Question(R.string.question_asia, true)
    )

    var currentIndex = 0
}