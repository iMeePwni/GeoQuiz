package com.imeepwni.geoquiz.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.Toast
import com.imeepwni.geoquiz.R
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        true_button.setOnClickListener({
            showToast(R.string.correct_toast)
        })
        false_button.setOnClickListener({
            showToast(R.string.correct_toast)
        })

    }

    private fun showToast(resId: Int) {
        val toast = Toast.makeText(this, resId, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }
}
