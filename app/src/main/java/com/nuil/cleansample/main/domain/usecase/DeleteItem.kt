package com.nuil.cleansample.main.domain.usecase

import com.nuil.cleansample.main.domain.repository.ItemsRepository
import io.reactivex.Observable

class DeleteItem(private val repo: ItemsRepository) {
    fun excute(): Observable<String> {
        return repo.deleteItem()
    }
}