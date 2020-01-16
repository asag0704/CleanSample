package com.nuil.cleansample.main.domain.usecase

import com.nuil.cleansample.main.domain.repository.ItemsRepository

class AddItem(private val repo: ItemsRepository) {
    fun excute(string: String): String {
        return repo.addItem(string)
    }
}