import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

// Cliente HTTP compatible con KMP
val httpClient = HttpClient {
    install(ContentNegotiation) {
        json()
    }
}

// Modelo de datos
@Serializable
data class MemeResponse(
    val success: Boolean,
    val data: MemeData
)

@Serializable
data class MemeData(val memes: List<Meme>)

@Serializable
data class Meme(
    val id: String,
    val name: String,
    val url: String,
    val width: Int,
    val height: Int
)

// Función para obtener memes
suspend fun getMemes(): List<Meme> {
    val responseText: String = httpClient.get("https://api.imgflip.com/get_memes").body()

    val response: MemeResponse = Json {
        ignoreUnknownKeys = true // 🔥 Ignora cualquier campo desconocido
    }.decodeFromString(responseText)

    return response.data.memes
}
