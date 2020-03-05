package com.pse.psewatcher.dagger.modules.api

import com.pse.psewatcher.BuildConfig
import com.tickr.tickr.api.utils.RxErrorHandlingCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by bry1337 on 14/03/2018.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@Singleton
@Module
class ApiModule {

  companion object {
    private const val TIMEOUT_IN_SECONDS: Int = 60
  }

  @Provides
  @Singleton
  internal fun provideOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
      val logginInterceptor = HttpLoggingInterceptor()
      logginInterceptor.level = HttpLoggingInterceptor.Level.BODY
      builder.addInterceptor(logginInterceptor)
    }

    builder.connectTimeout(TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS).readTimeout(TIMEOUT_IN_SECONDS.toLong(),
        TimeUnit.SECONDS)
    return builder.build()
  }

  @Provides
  @Singleton
  internal fun provideRestAdapter(okHttpClient: OkHttpClient): Retrofit {
    val builder = Retrofit.Builder()
    builder.client(okHttpClient)
//        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
    return builder.build()
  }
}