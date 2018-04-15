package com.lxch.memoryleak

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 非静态内部类
 */
class InnerThreadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RunningThread().start()
        //模拟销货
        close.setOnClickListener { finish() }
    }

    /**
     * 错误 会引起内存泄漏
     */
    class RunningThread1 : Thread() {
        override fun run() {
            super.run()
            try {
                while (true)
                    Thread.sleep(10 * 1000)
            } catch (e: Exception) {
            }
        }
    }

    /**
     * 正确 静态内部类
     */
    internal inner class RunningThread : Thread() {
        override fun run() {
            super.run()
            try {
                while (true)
                    Thread.sleep(10 * 1000)
            } catch (e: Exception) {
            }
        }
    }


}
