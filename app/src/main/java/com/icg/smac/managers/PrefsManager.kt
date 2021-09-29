package com.icg.smac.managers

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

object PrefsManager {

    const val FILE_NAME = "datastore_prefs"
    const val USERNAME = "dsp_username"
    const val PASSWORD = "dsp_password"
    const val ROLE = "dsp_role"
    private const val NOT_FOUND = "not_found"

    val PREF_USERNAME = stringPreferencesKey(USERNAME)
    val PREF_PASSWORD = stringPreferencesKey(PASSWORD)
    val PREF_ROLE = stringPreferencesKey(ROLE)

    private lateinit var dataStore: DataStore<Preferences>

    fun initialise(d: DataStore<Preferences>) {
        dataStore = d
    }

    suspend fun isStringDataStorePrefPresent(prefKey: Preferences.Key<String>): Boolean =
        isDataStorePrefPresent(prefKey)

    private suspend fun <T> isDataStorePrefPresent(prefKey: Preferences.Key<T>): Boolean {
        val f: Flow<Any> = dataStore.data
            .map { preferences ->
                preferences[prefKey] ?: NOT_FOUND
            }

        return f.first() != NOT_FOUND
    }

    fun saveStringDataStorePref(stringPrefKey: Preferences.Key<String>, value: String) =
        saveDataStorePref(stringPrefKey, value)


    private fun <T> saveDataStorePref(prefKey: Preferences.Key<T>, value: T) {
        runBlocking {
            dataStore.edit { settings ->
                settings[prefKey] = value
            }
        }
    }

    suspend fun getStringDataStorePref(prefKey: Preferences.Key<String>): String =
        getDataStorePref(prefKey)

    private suspend fun <T> getDataStorePref(prefKey: Preferences.Key<T>): T {
        return dataStore.data
            .map { preferences ->
                preferences[prefKey] ?: NOT_FOUND
            }.first() as T
    }

}