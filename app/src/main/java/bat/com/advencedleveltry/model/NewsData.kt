package bat.com.advencedleveltry.model

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)