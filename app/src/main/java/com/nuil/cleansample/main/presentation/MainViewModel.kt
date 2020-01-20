package com.nuil.cleansample.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nuil.cleansample.main.domain.usecase.AddItem
import com.nuil.cleansample.main.domain.usecase.DeleteItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainViewModel(
    private val addItem: AddItem,
    private val deleteItem: DeleteItem
) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    // LiveData의 내부 접근을 막기 위해 별도의 변수에 getter 선언
    private var _item: MutableLiveData<String> = MutableLiveData()
    val item: LiveData<String>
        get() = _item

    fun addItem(string: String) {
        /**
         * setValue / postValue 상황별 사용 비교
         */
        disposable.add(
            addItem.excute(string)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .map { it.transform() }
                .subscribe { _item.value = it }
        )
    }

    fun deleteItem() {
        disposable.add(
            deleteItem.excute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { _item.value = it }
        )
    }

    override fun onCleared() {
        if (!disposable.isDisposed) disposable.dispose()
        super.onCleared()
    }
}