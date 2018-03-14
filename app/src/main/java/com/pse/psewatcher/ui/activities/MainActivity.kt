package com.pse.psewatcher.ui.activities

import com.pse.psewatcher.R

class MainActivity : ToolBarBaseActivity() {
  override val isActionBarBackbuttonEnabled: Boolean
    get() = false

  override fun setupActivityLayout() {
    setContentView(R.layout.activity_main)
  }

  override fun setupViewElements() {
  }

  override fun injectDaggerComponent() {
  }

}
