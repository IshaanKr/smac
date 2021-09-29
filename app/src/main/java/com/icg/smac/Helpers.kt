package com.icg.smac

import android.content.Context
import com.icg.smac.managers.PrefsManager.FILE_NAME
import com.icg.smac.managers.PrefsManager.PREF_PASSWORD
import com.icg.smac.managers.PrefsManager.PREF_USERNAME
import com.icg.smac.managers.PrefsManager.USERNAME
import com.icg.smac.managers.PrefsManager.isStringDataStorePrefPresent
import com.icg.smac.managers.PrefsManager.saveStringDataStorePref
import kotlinx.coroutines.runBlocking


val dummyItems = listOf("Option 1", "Option 2", "Option 3", "Option 4")

fun isUserLoggedIn(): Boolean = runBlocking { isStringDataStorePrefPresent(PREF_USERNAME) }

fun saveUserName(value: String) = saveStringDataStorePref(PREF_USERNAME, value)
fun savePassword(value: String) = saveStringDataStorePref(PREF_PASSWORD, value)

