package den.ter.feature_start_screen.di

import dagger.Binds
import dagger.Module
import den.ter.feature_start_screen.data.StartRepository
import den.ter.feature_start_screen.domain.repository.StartRepositoryInterface

@Module
interface StartRepoModule {

    @Binds
    fun bindrepo(repo: StartRepository):StartRepositoryInterface
}