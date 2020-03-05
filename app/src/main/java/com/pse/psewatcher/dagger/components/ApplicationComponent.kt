package com.pse.psewatcher.dagger.components

import com.pse.psewatcher.dagger.modules.ApplicationModule
import com.pse.psewatcher.dagger.modules.api.ApiModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by bry1337 on 14/03/2018.
 *
 * @author edwardbryan.abergas@gmail.com
 */
@Singleton
@Component(modules = [ApplicationModule::class, ApiModule::class])
interface ApplicationComponent {
}