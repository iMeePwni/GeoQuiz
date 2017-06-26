package com.imeepwni.geoquiz.model.respository

import org.junit.*

/**
 * Create by guofeng on 2017/6/26.
 */
class QuestionRepositoryTest {

    @Test
    fun getCurrentIndex() {
        Assert.assertTrue(QuestionRepository.currentIndex >= -1)
    }

    @Test
    fun nextQuestion() {
        val tempIndex = QuestionRepository.currentIndex
        val questionSize = QuestionRepository.questions.size

        QuestionRepository.nextQuestion()

        Assert.assertTrue(tempIndex % questionSize==QuestionRepository.currentIndex % questionSize - 1)
    }

    @Test
    fun prevQuestion() {
        val questionSize = QuestionRepository.questions.size
        val tempIndex = QuestionRepository.currentIndex + questionSize

        QuestionRepository.prevQuestion()

        Assert.assertTrue(tempIndex % questionSize==QuestionRepository.currentIndex % questionSize + 1)
    }

    @Test
    fun currentQuestion() {
        Assert.assertTrue(QuestionRepository.currentIndex==0)
    }

}