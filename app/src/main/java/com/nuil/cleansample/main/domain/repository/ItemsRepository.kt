package com.nuil.cleansample.main.domain.repository

import com.nuil.cleansample.main.data.ItemModel
import io.reactivex.Single

interface ItemsRepository {
    fun addItem(string: String): Single<ItemModel>
    fun deleteItem(): Single<ItemModel>
}