package bat.com.advencedleveltry.api

import bat.com.advencedleveltry.model.NewsData
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {
    @GET("top-headlines?sources=techcrunch&apiKey=ab1f6c97008a48d3b334857d289cbc9e")
    fun getAllNews(): Call<NewsData>
}