package com.lxch.memoryleak

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class HandlerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        close.setOnClickListener { finish() }
        var handler = WeakHandler(this)
        handler.sendEmptyMessageDelayed(11, 60 * 1000)

    }

    class MyHandler(var context: Context) : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            Toast.makeText(context, "toast", Toast.LENGTH_SHORT).show()
        }
    }

    internal inner class WeakHandler(var activity: HandlerActivity) : Handler() {
        var weekHandler: WeakReference<HandlerActivity>? = null

        init {
            weekHandler = WeakReference(activity)
        }

        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            val get = weekHandler!!.get()
            if (get != null) {
                Toast.makeText(activity, "weakhandler", Toast.LENGTH_SHORT).show()
            }
        }
    }
}