package com.example.photogalleryapp.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photogalleryapp.domain.models.PhotoModel
import com.example.photogalleryapp.domain.usecase.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val _photos = MutableStateFlow<List<PhotoModel>>(emptyList())
    val photos: StateFlow<List<PhotoModel>> = _photos.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val _error = MutableSharedFlow<String>()
    val error: SharedFlow<String> = _error.asSharedFlow()
    init {
        fetchPhotos(forceRefresh = true)
    }
    fun fetchPhotos(forceRefresh: Boolean = false) {
        if (_loading.value) {
            return
        }

        _loading.value = true
        viewModelScope.launch {
            try {
                val fetchedPhotos = getPhotosUseCase(forceRefresh)
                _photos.value = fetchedPhotos
            } catch (e: Exception) {
                Log.e("PhotoViewModel", "خطأ أثناء جلب الصور: ${e.message}", e)
                _error.emit("فشل جلب الصور: ${e.message ?: "خطأ غير معروف"}")
            } finally {
                _loading.value = false
            }
        }
    }
}
