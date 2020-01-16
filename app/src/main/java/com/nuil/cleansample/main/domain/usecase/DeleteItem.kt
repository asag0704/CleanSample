package com.nuil.cleansample.main.domain.usecase

import com.nuil.cleansample.main.domain.repository.ItemsRepository

class DeleteItem(private val repo: ItemsRepository) {
    fun excute(): String {
        return repo.deleteItem()
    }
}