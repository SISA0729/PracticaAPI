package org.example.project.shared.View
import Meme
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import getMemes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MemeViewModel : ViewModel() {
    private val _memes = MutableStateFlow<List<Meme>>(emptyList())
    val memes: StateFlow<List<Meme>> = _memes

    init {
        fetchMemes()
    }

    private fun fetchMemes() {
        viewModelScope.launch {
            try {
                _memes.value = getMemes()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
