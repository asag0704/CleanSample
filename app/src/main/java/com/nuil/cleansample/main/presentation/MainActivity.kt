package com.nuil.cleansample.main.presentation

import android.os.Bundle
import com.nuil.cleansample.R
import com.nuil.cleansample.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(R.id.frame, MainFragment())
    }
}

/**
 * 1. fragment 로 변경 (선택 - ktx) - 완료
 * 2. viewModel owner 체크, lifeCycle 관련, sharedViewModel(선택) , dependency 추가 - 진행중
 * 3. repo rxjava로 변경 - delay 2초 뒤 결과 반환 - 완료
 * 4. DataMapper 적용
 * 5. 스타일가이드 보고오기
 *
 */
