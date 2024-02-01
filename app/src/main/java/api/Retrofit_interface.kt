package api

import data.ImageModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import util.Constants

interface Retrofit_interface {
    @GET("v2/search/image")
    suspend fun searchImage(
        @Header("Authorization") apiKey: String = Constants.AUTH_HEADER,
        @Query("query") query : String,
        @Query("sort") sort : String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ) : ImageModel?
}