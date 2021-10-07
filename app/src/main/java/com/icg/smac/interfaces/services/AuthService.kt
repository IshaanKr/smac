package com.icg.smac.interfaces.services

import com.icg.smac.models.requests.LoginReq
import com.icg.smac.models.responses.LoginRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthService {

    @Deprecated("API has too many bugs")
    @POST("login")
    fun tempLoginBlocking(@Body req: LoginReq): Call<List<LoginRes>>
}