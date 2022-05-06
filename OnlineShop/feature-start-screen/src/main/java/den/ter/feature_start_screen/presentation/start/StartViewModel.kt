package den.ter.feature_start_screen.presentation.start

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.cartmodel.CartModel
import den.ter.feature_start_screen.domain.usecase.GetBestAndHotsUseCase
import den.ter.feature_start_screen.domain.usecase.GetCartCountUseCase
import kotlinx.coroutines.launch

class StartViewModel(
    private val getBestAndHotsUseCase: GetBestAndHotsUseCase,
    private val getCartCountUseCase: GetCartCountUseCase,
) : ViewModel() {

    private val _resp = MutableLiveData<BestAndHotModel>()

    val resp: LiveData<BestAndHotModel>
        get() = _resp

    private val _resp2 = MutableLiveData<CartModel>()

    val respCart: LiveData<CartModel>
        get() = _resp2


    fun getBestsAndHots() = viewModelScope.launch {
        getBestAndHotsUseCase.execute().let {
            if (it.isSuccessful) {
                _resp.postValue(it.body())
            } else {
                Log.d("mytag", "Error Response")
            }
        }
    }

    fun getCart() = viewModelScope.launch {
        getCartCountUseCase.execute().let {
            if (it.isSuccessful) {
                _resp2.postValue(it.body())
            } else {
                Log.d("mytag", "Error Response")
            }
        }
    }
}