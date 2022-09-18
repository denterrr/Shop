package den.ter.feature_start_screen.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.feature_start_screen.data.database.BestDatabase
import den.ter.feature_start_screen.data.database.HotDatabase
import den.ter.feature_start_screen.data.database.dao.BestDao
import den.ter.feature_start_screen.data.database.dao.HotDao
import den.ter.feature_start_screen.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class GetHotUseCaseTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    lateinit var database: HotDatabase
    lateinit var hotDao: HotDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            HotDatabase::class.java
        ).allowMainThreadQueries().build()
        hotDao = database.getHotDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun should_Insert_And_Get_Data() = runTest {
        val item = HomeStore(0,true,true,"","","test")
        hotDao.insert(item)

        val allItems = hotDao.getHots().getOrAwaitValue()
        Truth.assertThat(allItems).contains(item)
    }
}