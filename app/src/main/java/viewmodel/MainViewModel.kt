package viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import repository.Repository
import retrofit2.Response

class MainViewModel(private val repository : Repository) : ViewModel() {

    val myCustomPosts : MutableLiveData<Response<ImageSearchResponse>> = MutableLiveData()

    fun searchImage(){
        viewModelScope.launch {
            val response = repository.searchImage("페이커","accuracy")
            myCustomPosts.value = response
        }
    }