package com.nuil.cleansample.main.domain.usecase

import com.nuil.cleansample.main.data.ItemModel
import com.nuil.cleansample.main.domain.repository.ItemsRepository
import com.nuil.cleansample.main.entity.ItemEntity
import io.reactivex.Observable
import io.reactivex.Single

class DeleteItem(private val repo: ItemsRepository) {
    fun excute(): Single<ItemEntity> {
        return repo.deleteItem()
    }
}