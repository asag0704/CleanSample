package com.nuil.cleansample.main.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nuil.cleansample.base.BaseViewModel
import com.nuil.cleansample.main.domain.usecase.AddItem
import com.nuil.cleansample.main.domain.usecase.DeleteItem

class MainViewModel(
    private val addItem: AddItem,
    private val deleteItem: DeleteItem
) : BaseViewModel() {

    private var _itemList: MutableLiveData<String> = MutableLiveData()
    val itemList: LiveData<String>
        get() = _itemList

    fun addItem(string: String) {
        /**
         * setValue / postValue 비교
         */


    }

    fun deleteItem() {
        itemList.value = deleteItem.excute()
    }
}