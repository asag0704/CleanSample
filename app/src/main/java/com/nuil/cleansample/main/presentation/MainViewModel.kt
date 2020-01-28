package com.nuil.cleansample.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nuil.cleansample.main.data.transform
import com.nuil.cleansample.main.domain.usecase.AddItem
import com.nuil.cleansample.main.domain.usecase.DeleteItem
import com.nuil.cleansample.main.entity.ItemEntity
import io.reactivex.disposables.CompositeDisposable


class MainViewModel(
    private val addItem: AddItem,
    private val deleteItem: DeleteItem
) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    // LiveData의 내부 접근을 막기 위해 별도의 변수에 getter 선언
    private var _item: MutableLiveData<ItemEntity> = MutableLiveData()
    val item: LiveData<ItemEntity>
        get() = _item

    fun addItem(string: String) {
        /**
         * setValue() : 메인 쓰레드에서 사용된다.
         *
         * postValue() : 백그라운드 쓰레드에서 사용되며
         *               메인 쓰레드에서 라이브데이터 값을 붙이는 형식으로 작동된다.
         *               관찰자가 없이 호출되고 뒤늦게 값을 관찰자가 생기더라도 그 전의 값을 받지 못한다.
         */
        disposable.add(
            addItem.excute(string)
                .subscribe({ response ->
                    _item.value = response
                }, Throwable::printStackTrace)
        )
    }

    fun deleteItem() {
        disposable.add(
            deleteItem.excute()
                .subscribe({ response ->
                    _item.value = response
                }, Throwable::printStackTrace)
        )
    }

    /**
     * 액티비티 스코프가 완전히 종료되는 시점에 호출됨
     * Memory leak 을 방지하기 위해 dispose 필수
     */
    override fun onCleared() {
        if (!disposable.isDisposed) disposable.dispose()
        super.onCleared()
    }
}