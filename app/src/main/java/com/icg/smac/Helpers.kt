package com.icg.smac

import com.icg.smac.managers.PrefsManager.PREF_PASSWORD
import com.icg.smac.managers.PrefsManager.PREF_USERNAME
import com.icg.smac.managers.PrefsManager.getStringDataStorePref
import com.icg.smac.managers.PrefsManager.isStringDataStorePrefPresent
import com.icg.smac.managers.PrefsManager.saveStringDataStorePref
import kotlinx.coroutines.runBlocking


val dummyItems = listOf("Option 1", "Option 2", "Option 3", "Option 4")

fun isUserLoggedIn(): Boolean = runBlocking { isStringDataStorePrefPresent(PREF_USERNAME) }

fun saveUserName(value: String) = saveStringDataStorePref(PREF_USERNAME, value)
fun savePassword(value: String) = saveStringDataStorePref(PREF_PASSWORD, value)

suspend fun getUserName(): String = getStringDataStorePref(PREF_USERNAME)
suspend fun getUserRole(): String = "SuperAdmin"

