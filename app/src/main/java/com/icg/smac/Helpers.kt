package com.icg.smac

import android.app.Activity
import android.content.Context

const val PREF_USERNAME = "pref_username"
const val PREF_PASSWORD = "pref_password"


fun saveUserName(activity: Activity, value: String) = saveInPrefs(activity, PREF_USERNAME, value)
fun savePassword(activity: Activity, value: String) = saveInPrefs(activity, PREF_PASSWORD, value)

fun saveInPrefs(activity: Activity, key: String, value: String) =
    with(activity.getPreferences(Context.MODE_PRIVATE).edit()) {
        putString(key, value)
        apply()
    }

