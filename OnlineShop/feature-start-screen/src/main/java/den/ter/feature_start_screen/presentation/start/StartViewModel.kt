package den.ter.feature_start_screen.presentation.start

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.core.models.cartmodel.CartModel
import den.ter.feature_start_screen.domain.usecase.GetBestAndHotsUseCase
import den.ter.feature_start_screen.domain.usecase.GetBestUseCase
import den.ter.feature_start_screen.domain.usecase.GetCartCountUseCase
import den.ter.feature_start_screen.domain.usecase.GetHotUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class StartViewModel @Inject constructor(
    private val getBestAndHotsUseCase: GetBestAndHotsUseCase,
    private val getCartCountUseCase: GetCartCountUseCase,
//    private val getBestUseCase: GetBestUseCase,
//    private val getHotUseCase: GetHotUseCase
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

//    fun getBest() =   getBestUseCase.execute()
//
//
//    suspend fun insertBest(list: List<BestSeller>) = viewModelScope.launch {
//        getBestUseCase.insert(list)
//
//    }
//
//    fun getHot() = getHotUseCase.execute()
//
//    suspend fun insertHot(list: List<HomeStore>) = viewModelScope.launch {
//        getHotUseCase.insert(list)
//    }
}
