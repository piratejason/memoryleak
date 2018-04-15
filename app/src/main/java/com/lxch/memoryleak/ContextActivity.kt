package com.lxch.memoryleak

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 使用Context时,根据实际情况,尽量使用Application
 */
class ContextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val versionName = CommonHelper.getInstance(applicationContext).getVersionName()
        close.text=versionName
    }
}