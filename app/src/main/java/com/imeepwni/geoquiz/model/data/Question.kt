package com.imeepwni.geoquiz.model.data

data class Question(
        var textResId: Int,
        var answerTrue: Boolean,
        var isAnswered: Boolean = false,
        var isAnswerRight: Boolean? = null
)
