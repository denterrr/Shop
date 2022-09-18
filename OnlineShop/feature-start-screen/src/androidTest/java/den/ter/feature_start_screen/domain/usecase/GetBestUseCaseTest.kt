package den.ter.feature_start_screen.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.feature_start_screen.data.database.BestDatabase
import den.ter.feature_start_screen.data.database.dao.BestDao
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
class GetBestUseCaseTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    lateinit var database: BestDatabase
    lateinit var bestDao: BestDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            BestDatabase::class.java
        ).allowMainThreadQueries().build()
        bestDao = database.getBestDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun should_Insert_And_Get_Data() = runTest {
        val item = BestSeller(0, 0, true, "", 0, "test")
        bestDao.insert(item)

        val allItems = bestDao.getBests().getOrAwaitValue()
        Truth.assertThat(allItems).contains(item)
    }
}