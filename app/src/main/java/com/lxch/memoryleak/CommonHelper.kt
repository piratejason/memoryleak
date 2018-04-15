package com.lxch.memoryleak

import android.content.Context

object CommonHelper {
    private var instance: CommonHelper? = null
    private var context: Context? = null
    fun getInstance(context: Context): CommonHelper {
        if (instance == null) {
            creat(context)
        }
        return instance as CommonHelper
    }

    @Synchronized
    private fun creat(context: Context) {
        this.context = context
        instance = CommonHelper
    }

    fun getVersionName(): String? {
        if (context != null) {
            val packageInfo = context!!.packageManager.getPackageInfo(context!!.packageName, 0)
            return packageInfo.versionName
        } else {
            return ""
        }
    }
}