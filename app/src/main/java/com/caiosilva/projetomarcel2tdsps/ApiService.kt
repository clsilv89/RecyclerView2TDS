package com.caiosilva.projetomarcel2tdsps

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/photos")
    fun getPhotos(): Call<List<PhotoPost>>

    @POST("/posts")
    fun sendPost(@Body postPost: PostPost): Call<Post>
}