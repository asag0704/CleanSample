package com.nuil.cleansample.main.domain.usecase

import com.nuil.cleansample.main.domain.repository.ItemsRepository
import com.nuil.cleansample.main.data.ItemModel
import io.reactivex.Single

class AddItem(private val repo: ItemsRepository) {
    fun excute(string: String): Single<ItemModel> {
        return repo.addItem(string)
    }
}