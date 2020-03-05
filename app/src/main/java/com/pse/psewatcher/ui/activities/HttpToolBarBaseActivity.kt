package com.pse.psewatcher.ui.activities

import com.pse.psewatcher.api.utils.HttpStatusCode
import com.pse.psewatcher.managers.prefs.SharedPreferenceManager
import com.tickr.tickr.api.utils.RetrofitException
import rx.subscriptions.CompositeSubscription

/**
 * Created by bry1337 on 14/03/2018.
 *
 * @author edwardbryan.abergas@gmail.com
 */
abstract class HttpToolBarBaseActivity : ToolBarBaseActivity() {

  abstract val compositeSubscription: CompositeSubscription

  abstract fun onNetworkErrorFound(message: String)

  abstract fun onHttpErrorUnexpectedFound(message: String)

  fun handleHttpError(throwable: Throwable, sharedPreferenceManager: SharedPreferenceManager) {
    val e = throwable as RetrofitException
    if (e.kind == RetrofitException.Kind.HTTP) {
      val response = e.response
      if (response != null) {
        if (response.code() == HttpStatusCode.UNAUTHORIZED) {
          // TODO (bryan) handle unauthorized
        } else {
          onHttpErrorUnexpectedFound(response.message())
        }
      }
    } else if (e.kind == RetrofitException.Kind.UNEXPECTED) {
    }
  }


  override fun onDestroy() {
    super.onDestroy()
    if (compositeSubscription.hasSubscriptions()) {
      compositeSubscription.unsubscribe()
    }
  }
}