package hr.ferit.dinoradonjic.androidprojekt

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiEndpoints {
    @Headers("X-Api-Key: cc9O+/Fv8rzABWhKgHpyRQ==p6EC2SitQ1DTNQiF")
    @GET("v1/nutrition")
    fun getFood(@Query("query") query:String): Call<ResponseData>
}