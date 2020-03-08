package com.dimitare.angdim

import android.os.Bundle
import androidx.activity.viewModels
import com.dimitare.angdim.activities.BaseActivity
import com.dimitare.angdim.activities.main.MainActivityViewModel

class MainActivity : BaseActivity<MainActivityViewModel>() {
    override val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}