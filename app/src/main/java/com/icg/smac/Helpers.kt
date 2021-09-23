package com.icg.smac

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow


val dummyItems = listOf("Option 1", "Option 2", "Option 3", "Option 4")

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

fun saveInDataStore(context: Context, key: String, value: String) =
    with(context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).edit()) {
        putString(key, value)
        apply()
    }

//fun readIntFromDataStore(context: Context, key: String){
//    val EXAMPLE_COUNTER = intPreferencesKey(key)
//    val exampleCounterFlow: Flow<Int> = context.dataStore.data
//        .map { preferences ->
//            preferences[EXAMPLE_COUNTER] ?: 0
//        }
//}

