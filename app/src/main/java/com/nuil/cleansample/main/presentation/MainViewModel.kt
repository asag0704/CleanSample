package com.nuil.cleansample.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nuil.cleansample.base.BaseViewModel
import com.nuil.cleansample.main.domain.usecase.AddItem
import com.nuil.cleansample.main.domain.usecase.DeleteItem

class MainViewModel(
    private val addItem: AddItem,
    private val deleteItem: DeleteItem
) : BaseViewModel() {

    private var _item: MutableLiveData<String> = MutableLiveData()
    val item: LiveData<String>
        get() = _item

    fun addItem(string: String) {
        /**
         * setValue / postValue 상황별 사용 비교
         */
        _item.value = addItem.excute(string)
    }

    fun deleteItem() {
        _item.value = deleteItem.excute()
    }
}