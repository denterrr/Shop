package den.ter.feature_cart_screen.presentation.cart

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import den.ter.core.models.cartmodel.CartModel
import den.ter.core.models.detailmodel.DetailModel
import den.ter.feature_cart_screen.domain.usecase.GetCartDbUseCase
import den.ter.feature_cart_screen.domain.usecase.GetCartUseCase
import kotlinx.coroutines.launch

class CartViewModel(private val getCartUseCase: GetCartUseCase,
    private val getCartDbUseCase: GetCartDbUseCase) : ViewModel() {

    private val _resp = MutableLiveData<CartModel>()

    val resp: LiveData<CartModel>
        get() = _resp


    fun getCart() = viewModelScope.launch {
        getCartUseCase.execute().let {
            if (it.isSuccessful) {
                _resp.postValue(it.body())
            } else {
                Log.d("mytag", "Error Response")
            }
        }
    }

    fun getCartDb() = getCartDbUseCase.execute()


    suspend fun insert(model: CartModel) = viewModelScope.launch {
        getCartDbUseCase.insert(model)
    }
}