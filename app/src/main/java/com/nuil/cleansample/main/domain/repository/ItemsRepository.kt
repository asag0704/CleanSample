package com.nuil.cleansample.main.domain.repository

import io.reactivex.Observable

interface ItemsRepository {
    fun addItem(string: String): Observable<String>
    fun deleteItem(): Observable<String>
}