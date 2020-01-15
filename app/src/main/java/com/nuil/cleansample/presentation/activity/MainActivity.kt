package com.nuil.cleansample.presentation.activity

import android.os.Bundle
import com.nuil.cleansample.R
import com.nuil.cleansample.presentation.MainViewModel
import com.nuil.cleansample.presentation.fragment.MainFragment

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route)

        viewModel = MainViewModel()

        addFragment(R.id.fragmentContainer, MainFragment())
    }
}
