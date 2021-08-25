package com.icg.smac

import android.content.Context


const val PREF_FILE_NAME = "prefs"
const val PREF_USERNAME = "pref_username"
const val PREF_PASSWORD = "pref_password"


fun isUserLoggedIn(context: Context): Boolean = isPrefPresent(context, PREF_USERNAME)

fun saveUserName(context: Context, value: String) = saveInPrefs(context, PREF_USERNAME, value)
fun savePassword(context: Context, value: String) = saveInPrefs(context, PREF_PASSWORD, value)

fun saveInPrefs(context: Context, key: String, value: String) =
    with(context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).edit()) {
        putString(key, value)
        apply()
    }

fun isPrefPresent(context: Context, key: String) =
    context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).contains(key)

