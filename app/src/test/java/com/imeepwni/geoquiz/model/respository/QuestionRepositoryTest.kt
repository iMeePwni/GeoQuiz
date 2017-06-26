package com.imeepwni.geoquiz.model.respository

import org.junit.*

import org.junit.Assert.*

/**
 * Create by guofeng on 2017/6/26.
 */
class QuestionRepositoryTest {
    @Test
    fun modCurrentIndex() {
        QuestionRepository.currentIndex = 3

        val output = QuestionRepository.modCurrentIndex()

        Assert.assertEquals(3, output)
    }

}