package den.ter.feature_start_screen.di

import dagger.Component
import den.ter.core.di.CoreComponent
import den.ter.feature_start_screen.presentation.start.StartFragment
import javax.inject.Scope

@StartScope
@Component(modules = [StartModule::class, StartRepoModule::class], dependencies = [CoreComponent::class])
interface StartComponent {
    fun inject(startFragment: StartFragment)
}

@Scope
annotation class StartScope