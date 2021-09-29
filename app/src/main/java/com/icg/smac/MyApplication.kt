package com.icg.smac

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.icg.smac.managers.PrefsManager

class MyApplication : Application() {

    private val dataStore: DataStore<Preferences> by preferencesDataStore(name = PrefsManager.FILE_NAME)

    override fun onCreate() {
        super.onCreate()
        PrefsManager.initialise(dataStore)
    }
}