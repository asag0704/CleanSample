package com.nuil.cleansample.main.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer

import com.nuil.cleansample.R
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.koin.android.ext.android.inject


class MainFragment : Fragment() {
    private val viewModel: MainViewModel by inject()
    private var startTime: Long = 0
    private var endTime: Long = 0

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
            endTime = System.currentTimeMillis()
            Toast.makeText(context, "cal Time : ${endTime - startTime}", Toast.LENGTH_SHORT).show()
            view.stateText.text = it
        })
    }

    private fun initViews(view: View) {
        view.addBtn.setOnClickListener {
            startTime = System.currentTimeMillis()
            viewModel.addItem("Title")
        }

        view.deleteBtn.setOnClickListener {
            startTime = System.currentTimeMillis()
            viewModel.deleteItem()
        }
    }

}
