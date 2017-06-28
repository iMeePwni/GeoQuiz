package com.imeepwni.geoquiz.model.respository

import org.junit.*

/**
 * Create by guofeng on 2017/6/26.
 */
class QuestionRepositoryTest {
    @Test
    fun modCurrentIndex() {
        QuestionRepository.currentIndex = -1

        val output = QuestionRepository.modCurrentIndex()

        Assert.assertEquals(5, output)
    }

    @Test
    fun completeQuestion() {
        QuestionRepository.completeQuestion(true)
        val question = QuestionRepository.currentQuestion()

        Assert.assertTrue(question.isAnswered
                && question.isAnswerRight ?: false)
    }

    @Test
    fun isCompletedAllQuestion() {
        Assert.assertTrue(!QuestionRepository.isCompletedAllQuestion())
    }

}