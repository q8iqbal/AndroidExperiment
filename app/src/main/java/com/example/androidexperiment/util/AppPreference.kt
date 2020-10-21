package com.example.androidexperiment.util

import android.content.Context
import android.content.SharedPreferences


object AppPreference {
    private lateinit var mSharedPref: SharedPreferences
    private const val PREFS_NAME = "params"
    const val EMAIL = "EMAIL"
    const val PASSWORD = "PASSWORD"

    private fun SharedPref() {}

    fun init(context: Context) {
        mSharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun read(key: String, value: String): String? {
        return mSharedPref.getString(key, value)
    }

    fun read(key: String, value: Long): Long? {
        return mSharedPref.getLong(key, value)
    }

    fun write(key: String, value: String) {
        val prefsEditor: SharedPreferences.Editor = mSharedPref.edit()
        with(prefsEditor) {
            putString(key, value)
            commit()
        }
    }

    fun write(key: String, value: Long) {
        val prefsEditor: SharedPreferences.Editor = mSharedPref.edit()
        with(prefsEditor) {
            putLong(key, value)
            commit()
        }
    }
}