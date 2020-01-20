package com.nuil.cleansample.main.domain.usecase

import com.nuil.cleansample.main.domain.repository.ItemsRepository
import io.reactivex.Observable

class AddItem(private val repo: ItemsRepository) {
    fun excute(string: String): Observable<String> {
        return repo.addItem(string)
    }
}