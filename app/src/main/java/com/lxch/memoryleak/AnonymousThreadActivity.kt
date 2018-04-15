package com.lxch.memoryleak

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class AnonymousThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        close.setOnClickListener { finish() }
        var thread = object : Thread() {
            override fun run() {
                super.run()
                try {
                    while (true) {
                        Thread.sleep(60 * 1000)
                        return
                    }
                } catch (e: Exception) {
                }
            }
        }
        thread.start()
    }
}