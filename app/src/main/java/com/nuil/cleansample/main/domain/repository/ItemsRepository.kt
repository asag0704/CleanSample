package com.nuil.cleansample.main.domain.repository

import com.nuil.cleansample.main.entity.ItemEntity
import io.reactivex.Single

interface ItemsRepository {
    fun addItem(string: String): Single<ItemEntity>
    fun deleteItem(): Single<ItemEntity>
}