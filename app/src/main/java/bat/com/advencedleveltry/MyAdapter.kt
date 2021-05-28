package bat.com.advencedleveltry

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bat.com.advencedleveltry.model.NewsData

class MyAdapter(val context: Context, val newsData: NewsData) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var author: TextView
        var title: TextView

        init {
            author = itemView.findViewById(R.id.author)
            title = itemView.findViewById(R.id.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.author.text = newsData.articles[position].author
        holder.title.text = newsData.articles[position].title
    }

    override fun getItemCount(): Int {
        return newsData.articles.size
    }
}