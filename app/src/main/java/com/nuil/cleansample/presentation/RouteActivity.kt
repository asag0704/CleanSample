package com.nuil.cleansample.presentation

import android.os.Bundle
import com.nuil.cleansample.R

class RouteActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route)

        addFragment(R.id.fragmentContainer, TasksFragment())
    }
}
