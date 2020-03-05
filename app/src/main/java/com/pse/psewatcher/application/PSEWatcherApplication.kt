package com.pse.psewatcher.application

import android.content.Context
import com.pse.psewatcher.dagger.components.ApplicationComponent
import com.pse.psewatcher.dagger.components.DaggerApplicationComponent
import com.pse.psewatcher.dagger.modules.ApplicationModule

/**
 * Created by bry1337 on 14/03/2018.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class PSEWatcherApplication : BaseApplication() {

  companion object {
    operator fun get(context: Context): PSEWatcherApplication {
      return context.applicationContext as PSEWatcherApplication
    }
  }

  private lateinit var applicationComponent: ApplicationComponent

  override fun onCreate() {
    super.onCreate()
    initAppComponent()
  }

  private fun initAppComponent() {
    applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
  }
}