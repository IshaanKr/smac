package com.icg.smac.models.responses

data class LoginRes(
    val message: String,
    val is_ACTIVE: String,
    val firstname: String,
    val lastname: String,
    val gender: String,
    val panno: String,
    val state: String,
    val tech_ID: String,
    val mobile_NO: String,
    val pan_NO: String,
    val adhaar_NO: String,
    val org: String,
    val city: String,
    val desig: String,
    val official_EMAIL: String,
    val personal_EMAIL: String
)