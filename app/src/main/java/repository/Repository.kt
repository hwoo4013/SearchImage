package repository

import api.Retrofit_client
import data.ImageModel
import retrofit2.Response

class Repository {

    suspend fun searchImage(query : String, sort : String) : ImageModel? {
        return Retrofit_client.api.searchImage(query = query, sort = sort, page = 1, size = 5)
    }
}