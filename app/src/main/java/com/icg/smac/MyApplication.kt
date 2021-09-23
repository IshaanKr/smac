package com.icg.smac

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

class MyApplication : Application() {

//    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "datastore_prefs")
//
//    companion object {
//        private var _dataStore: DataStore<Preferences>? = null
//        val dataStore: DataStore<Preferences>
//            get() = _dataStore!!
//    }
//
    override fun onCreate() {
        super.onCreate()

    }
}