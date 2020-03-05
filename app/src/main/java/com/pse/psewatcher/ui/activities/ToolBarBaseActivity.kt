package com.pse.psewatcher.ui.activities

import android.support.v7.widget.Toolbar
import butterknife.BindView
import com.pse.psewatcher.R
import com.pse.psewatcher.ui.BaseActivity

/**
 * Created by bry1337 on 14/03/2018.
 *
 * @author edwardbryan.abergas@gmail.com
 */
abstract class ToolBarBaseActivity : BaseActivity() {
  @BindView(R.id.toolbar)
  private var toolbar: Toolbar? = null

  override fun setupToolbar() {
    setSupportActionBar(toolbar)
  }
}