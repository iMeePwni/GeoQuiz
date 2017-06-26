package com.imeepwni.geoquiz.app

import android.app.Application
import android.content.Context

/**
* Created by guofeng on 2017/6/26.
*/
class MyApplication : Application() {

    companion object {
        lateinit var CONTEXT : Context
    }

    override fun onCreate() {
        super.onCreate()

    }
}
