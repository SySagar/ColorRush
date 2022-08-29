package com.example.colorrush

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.PUT

interface Githubstar {

    @Headers("Accept: application/vnd.github+json",)
    @PUT("/user/starred/SySagar/ColorRush")
    suspend fun makeStar(@Body requestBody: RequestBody): Response<ResponseBody>

}