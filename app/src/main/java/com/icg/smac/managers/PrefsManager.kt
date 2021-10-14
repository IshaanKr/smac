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

    private const val NOT_FOUND = "not_found"

    const val FILE_NAME = "datastore_prefs"

    object Keys {
        const val USERNAME = "dsp_username"
        const val PASSWORD = "dsp_password"
        const val ROLE = "dsp_role"
    }

    object Prefs {
        val USERNAME = stringPreferencesKey(Keys.USERNAME)
        val PASSWORD = stringPreferencesKey(Keys.PASSWORD)
        val ROLE = stringPreferencesKey(Keys.ROLE)
    }

    lateinit var dataStore: DataStore<Preferences>

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


    suspend inline fun <reified T> saveDataStorePref(prefKey: Preferences.Key<T>, value: Any) =
        dataStore.edit { it[prefKey] = value as T }


    suspend fun getStringDataStorePref(prefKey: Preferences.Key<String>): String =
        getDataStorePref(prefKey)

    private suspend inline fun <reified T> getDataStorePref(prefKey: Preferences.Key<T>): T {
        return dataStore.data
            .map { preferences ->
                preferences[prefKey] ?: NOT_FOUND
            }.first() as T
    }

}