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
         * setValue / postValue 상황별 사용 비교
         */
        disposable.add(
            addItem.excute(string)
                .map { it.transform() }
                .subscribe({ response ->
                    _item.value = response
                }, Throwable::printStackTrace)
        )
    }

    fun deleteItem() {
        disposable.add(
            deleteItem.excute()
                .map { it.transform() }
                .subscribe({ response ->
                    _item.value = response
                }, Throwable::printStackTrace)
        )
    }

    override fun onCleared() {
        if (!disposable.isDisposed) disposable.dispose()
        super.onCleared()
    }
}