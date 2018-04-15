package com.lxch.memoryleak

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 未释放静态
 */
class EventBusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
        close.setOnClickListener { finish() }
        MyThread().start()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getMessage(message: MessageEvent) {
        Toast.makeText(this, message.message, Toast.LENGTH_SHORT).show()
    }

    internal inner class MyThread : Thread() {
        override fun run() {
            super.run()
            Thread.sleep(10*1000)
            EventBus.getDefault().post(MessageEvent("shit"))
        }
    }
}