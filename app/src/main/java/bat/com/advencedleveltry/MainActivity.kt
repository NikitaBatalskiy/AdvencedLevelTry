package bat.com.advencedleveltry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bat.com.advencedleveltry.api.NewsApi
import bat.com.advencedleveltry.model.NewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var txtId: TextView? = null
    var recyclerViewForNews: RecyclerView? = null
    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //        txtId = findViewById(R.id.txtId)
        recyclerViewForNews = findViewById(R.id.recyclerViewForNews)
        recyclerViewForNews?.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerViewForNews?.layoutManager = linearLayoutManager
        configureRetrofit()

    }

    private fun configureRetrofit() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MainActivity.BASE_URL)
            .build()
            .create(NewsApi::class.java)
        val retrofitData = retrofitBuilder.getAllNews()
        retrofitData.enqueue(object : Callback<NewsData?> {
            override fun onResponse(call: Call<NewsData?>, response: Response<NewsData?>) {
                val responseBody = response.body()!!
//            val myAdapter = MyAdapter(,responseBody)

//                У меня получилось взять Джсон объект и записать в TextView конкретные элементы,
//                но столкнулся с трудностью в выводе их в RecyclerView, на данном этапе знаний не смог справиться с этой проблемой

//                val myString = StringBuilder()
//                    for (newsData in responseBody.articles) {
//                        myString.append(newsData.author)
//                        myString.append("\n")
//                    }
//
//                    txtId?.text = myString
//                    Log.d("OK", "OK")
            }

            override fun onFailure(call: Call<NewsData?>, t: Throwable) {
                Log.d("Failure", "On failure: " + t.message)
            }
        })
    }
}