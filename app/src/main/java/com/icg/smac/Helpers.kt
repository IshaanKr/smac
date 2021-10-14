package com.icg.smac

import com.icg.smac.managers.PrefsManager
import com.icg.smac.managers.PrefsManager.getStringDataStorePref
import com.icg.smac.managers.PrefsManager.isStringDataStorePrefPresent
import com.icg.smac.managers.PrefsManager.saveDataStorePref


val dummyItems = listOf("Option 1", "Option 2", "Option 3", "Option 4")

suspend fun isUserLoggedIn(): Boolean =
    isStringDataStorePrefPresent(PrefsManager.Prefs.USERNAME)

suspend fun saveUserName(value: String) = saveDataStorePref(PrefsManager.Prefs.USERNAME, value)
suspend fun savePassword(value: String) = saveDataStorePref(PrefsManager.Prefs.PASSWORD, value)

suspend fun getUserName(): String = getStringDataStorePref(PrefsManager.Prefs.USERNAME)
suspend fun getUserRole(): String = "SuperAdmin"

