package den.ter.feature_start_screen.presentation.start

import android.util.Log
import androidx.lifecycle.viewModelScope
import den.ter.feature_start_screen.domain.usecase.GetBestAndHotsUseCase
import den.ter.feature_start_screen.domain.usecase.GetCartCountUseCase
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

@InjectViewState
class StartPresenter @Inject constructor(
    private val getBestAndHotsUseCase: GetBestAndHotsUseCase,
    private val getCartCountUseCase: GetCartCountUseCase) : MvpPresenter<StartView>() {

    fun getBestsAndHots() = presenterScope.launch {
        getBestAndHotsUseCase.execute().let {
            if (it.isSuccessful) {
                viewState.getBestAndHots(it.body()!!)
            } else {
                Log.d("mytag", "Error Response")
            }
        }
    }

    fun getCartCount() = presenterScope.launch {
        getCartCountUseCase.execute().let {
            if (it.isSuccessful) {
                viewState.getCartCount(it.body()?.basket?.size!!)
            } else {
                Log.d("mytag", "Error Response")
            }
        }
    }

}