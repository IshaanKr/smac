package com.icg.smac.models.requests

data class LoginReq(
    val usertype: String,
    val userid: String,
    val password: String
)