package com.nuil.cleansample.main.domain.usecase

import com.nuil.cleansample.main.domain.repository.ItemsRepository
import com.nuil.cleansample.main.data.ItemModel
import com.nuil.cleansample.main.entity.ItemEntity
import io.reactivex.Single

class AddItem(private val repo: ItemsRepository) {
    fun excute(string: String): Single<ItemEntity> {
        return repo.addItem(string)
    }
}