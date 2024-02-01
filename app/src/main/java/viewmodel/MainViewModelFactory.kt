package viewmodel

import androidx.lifecycle.ViewModel


// 뷰모델에 인자를 넘겨주기

class MainViewModelFactory (
    private val repository : Repository
) : ViewModelProbider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}
