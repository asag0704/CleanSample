package com.nuil.cleansample.main.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.nuil.cleansample.R
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.koin.android.ext.android.inject


class MainFragment : Fragment() {
    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        initViewModel(view)
        initViews(view)
        return view
    }

    private fun initViewModel(view: View) {
        viewModel.item.observe(viewLifecycleOwner, Observer {
            view.stateText.text = it
        })
    }

    private fun initViews(view: View) {
        view.addBtn.setOnClickListener { viewModel.addItem("add") }
        view.deleteBtn.setOnClickListener { viewModel.deleteItem() }
    }

}
