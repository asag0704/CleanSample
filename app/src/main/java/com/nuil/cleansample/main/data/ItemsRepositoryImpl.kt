package com.nuil.cleansample.main.data

import com.nuil.cleansample.main.domain.repository.ItemsRepository

class ItemsRepositoryImpl : ItemsRepository {
    override fun addItem(string: String): String {
        return "addItem"
    }

    override fun deleteItem(): String {
        return "deleteItem"
    }
}