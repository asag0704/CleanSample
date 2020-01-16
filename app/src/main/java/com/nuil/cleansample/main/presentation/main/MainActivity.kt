package com.nuil.cleansample.main.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.nuil.cleansample.R
import kotlinx.android.synthetic.main.activity_route.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route)



        /**
         * fragment로 작성하자.
         */
        initViewModel()
        initViews()
    }

    private fun initViewModel() {
        viewModel.itemList.observe(this, Observer {

        })
    }

    private fun initViews() {
        addBtn.setOnClickListener { viewModel.addItem("test") }
        deleteBtn.setOnClickListener { viewModel.deleteItem() }
    }
}

/**
 * 1. fragment 로 변경 (선택 - ktx)
 * 2. viewModel owner 체크, lifeCycle 관련, sharedViewModel(선택) , dependency 추가
 * 3. repo rxjava로 변경 - delay 2초 뒤 결과 반환
 * 4. DataMapper 적용
 * 5. 스타일가이드 보고오기
 *
 */
