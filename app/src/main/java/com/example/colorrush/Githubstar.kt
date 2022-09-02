package com.example.colorrush

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface Githubstar {


//    @PUT("/user/starred/SySagar/ColorRush")
//    suspend fun makeStar(@Body requestBody: RequestBody): Response<ResponseBody>


//    Call<AccessToken> getAccessToken(
//    @Field("client_id") String clientId,
//    @Field("client_secret") String clientSecret,
//    @Field("code") String code
//    )

    @Headers("Accept: application/vnd.github+json",)
    @POST("login/oauth/access_token")
    @FormUrlEncoded
    fun getAccessToken(
        @Field("client_id") clientId : String,
        @Field("client_secret") clientSecret : String,
        @Field("code") code : String,
    ): Call<AccessToken?>?

}