package den.ter.core.di

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [CoreModule::class])
@Singleton
interface CoreComponent {

    fun retofit(): Retrofit
}