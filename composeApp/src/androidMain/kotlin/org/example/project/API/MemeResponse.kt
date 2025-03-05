import retrofit2.http.GET

data class MemeResponse(val data: MemeData)
data class MemeData(val memes: List<Meme>)
data class Meme(
    val id: String,
    val name: String,
    val url: String,
    val width: Int,
    val height: Int
)

interface MemeApiService {
    @GET("get_memes")
    suspend fun getMemes(): MemeResponse
}
