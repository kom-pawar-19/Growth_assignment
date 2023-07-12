package com.example.myonboarding




import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("images")
    suspend fun getImages(): Response<List<Image>>


}
