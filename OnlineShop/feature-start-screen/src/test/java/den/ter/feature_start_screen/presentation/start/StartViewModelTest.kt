package den.ter.feature_start_screen.presentation.start

import androidx.lifecycle.LiveData
import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.feature_start_screen.data.database.dao.BestDao
import den.ter.feature_start_screen.data.database.dao.HotDao
import den.ter.feature_start_screen.domain.usecase.GetBestAndHotsUseCase
import den.ter.feature_start_screen.domain.usecase.GetBestUseCase
import den.ter.feature_start_screen.domain.usecase.GetCartCountUseCase
import den.ter.feature_start_screen.domain.usecase.GetHotUseCase
import io.mockk.*
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.jupiter.api.*
import retrofit2.Response
import kotlin.coroutines.coroutineContext

@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
class StartViewModelTest {


    val getBestAndHotsUseCase = mockk<GetBestAndHotsUseCase>(relaxed = true)
    val getCartCountUseCase = mockk<GetCartCountUseCase>(relaxed = true)
    val getBestUseCase = mockk<GetBestUseCase>(relaxed = true)
    val getHotUseCase = mockk<GetHotUseCase>(relaxed = true)
    val bestDao = mockk<BestDao>(relaxed = true)
    val hotDao = mockk<HotDao>(relaxed = true)
    val bestList = listOf<BestSeller>(
        BestSeller(0, 0, true, "", 0, "test"),
        BestSeller(0, 1, true, "", 0, "test2")
    )
    val hotList = listOf<HomeStore>(
        HomeStore(0, true, true, "", "", "testhot"),
        HomeStore(1, true, true, "", "", "testhot2"),
    )
    val bestAndHotModel = BestAndHotModel(bestList, hotList)


    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }


    @Test
    fun `should call GetBestAndHotUseCase`() {
        val startViewModel = StartViewModel(getBestAndHotsUseCase, getCartCountUseCase, getBestUseCase,getHotUseCase)
        startViewModel.getBestsAndHots()
        coVerify(exactly = 1) { getBestAndHotsUseCase.execute() }

    }

    @Test
    fun `should call GetCartCountUseCase`() {
        val startViewModel = StartViewModel(getBestAndHotsUseCase, getCartCountUseCase, getBestUseCase,getHotUseCase)
        startViewModel.getCart()
        coVerify(exactly = 1) { getCartCountUseCase.execute() }
    }

    @Test
    fun `should call GetBestUseCase`() {
        val startViewModel = StartViewModel(
            getBestAndHotsUseCase,
            getCartCountUseCase,
            getBestUseCase,
            getHotUseCase
        )
        startViewModel.getBest()
        coVerify(exactly = 1) { getBestUseCase.execute() }
    }

    @Test
    fun `should call GetHotUseCase`() {
        val startViewModel = StartViewModel(
            getBestAndHotsUseCase,
            getCartCountUseCase,
            getBestUseCase,
            getHotUseCase
        )
        startViewModel.getHot()
        coVerify(exactly = 1) { getHotUseCase.execute() }
    }

}