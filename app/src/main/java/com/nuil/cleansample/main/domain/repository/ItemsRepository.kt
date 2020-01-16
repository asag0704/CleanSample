package com.nuil.cleansample.main.domain.repository

interface ItemsRepository {
    fun addItem(string: String): String
    fun deleteItem(): String
}