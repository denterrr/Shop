package den.ter.feature_details_screen.di

import dagger.Binds
import dagger.Module
import den.ter.feature_details_screen.data.DetailsRepository
import den.ter.feature_details_screen.domain.repository.DetailsRepositoryInterface

@Module
interface DetailsRepoModule {

    @Binds
    fun bindDetailsRepo(repo: DetailsRepository): DetailsRepositoryInterface
}