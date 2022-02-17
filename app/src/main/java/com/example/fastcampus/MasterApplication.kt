package com.example.fastcampus

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class MasterApplication : Application() {

    val userId = 1000

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                Log.d("testt", "onActivityCreated")
            }

            override fun onActivityStarted(p0: Activity) {
                Log.d("testt", "onActivityStarted")
            }

            override fun onActivityResumed(p0: Activity) {
                Log.d("testt", "onActivityResumed")
            }

            override fun onActivityPaused(p0: Activity) {
                Log.d("testt", "onActivityPaused")
            }

            override fun onActivityStopped(p0: Activity) {
                Log.d("testt", "onActivityStopped")
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                Log.d("testt", "onActivitySaveInstanceState")
            }

            override fun onActivityDestroyed(p0: Activity) {
                Log.d("testt", "onActivityDestroyed")
            }
        })
    }


    fun methodFromApplication() {
        Log.d("testt", "methodFromApplication")
    }


}