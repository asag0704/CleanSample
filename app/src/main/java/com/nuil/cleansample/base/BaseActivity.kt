package com.nuil.cleansample.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    fun addFragment(containerId: Int, fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction();
        transaction.add(containerId, fragment)
        transaction.commit()
    }
}