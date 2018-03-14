package com.pse.psewatcher.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by bry1337 on 14/03/2018.
 *
 * @author edwardbryan.abergas@gmail.com
 */
abstract class BaseActivity : AppCompatActivity() {
  private var unbinder: Unbinder? = null

  protected abstract val isActionBarBackbuttonEnabled: Boolean

  protected abstract fun setupActivityLayout()

  protected abstract fun setupViewElements()

  protected abstract fun setupToolbar()

  protected abstract fun injectDaggerComponent()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setupActivityLayout()
    unbinder = ButterKnife.bind(this)
    injectDaggerComponent()
    setupToolbar()
    setupViewElements()
  }

  override fun onDestroy() {
    super.onDestroy()
    unbinder!!.unbind()
  }
}