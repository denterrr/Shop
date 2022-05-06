package den.ter.feature_details_screen.presentation.product

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import den.ter.core.models.detailmodel.DetailModel
import den.ter.feature_details_screen.domain.usecase.GetDetailsUseCase


import kotlinx.coroutines.launch

class ProductDetailViewModel(private val getDetailsUseCase: GetDetailsUseCase) : ViewModel() {

    private val _resp = MutableLiveData<DetailModel>()

    val resp: LiveData<DetailModel>
        get() = _resp

    fun getDetails() = viewModelScope.launch {
        getDetailsUseCase.execute().let {
            if (it.isSuccessful) {
                _resp.postValue(it.body())
            } else {
                Log.d("mytag", "Error Response")
            }
        }
    }
}