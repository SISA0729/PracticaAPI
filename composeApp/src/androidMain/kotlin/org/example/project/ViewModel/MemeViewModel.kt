import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MemeViewModel : ViewModel() {
    private val _memes = MutableStateFlow<List<Meme>>(emptyList())
    val memes: StateFlow<List<Meme>> = _memes

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.imgflip.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(MemeApiService::class.java)

    init {
        fetchMemes()
    }

    private fun fetchMemes() {
        viewModelScope.launch {
            try {
                val response = apiService.getMemes()
                _memes.value = response.data.memes
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
