package com.nuil.cleansample.main.data

import com.nuil.cleansample.main.domain.repository.ItemsRepository
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ItemsRepositoryImpl : ItemsRepository {
    override fun addItem(string: String): Observable<String> {
        return Single.create<String> { emitter ->
            emitter.onSuccess("delay $string")
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .delay(2000, TimeUnit.MILLISECONDS)
            .toObservable()
    }

    override fun deleteItem(): Observable<String> {
        return Single.create<String> { emitter ->
            emitter.onSuccess("delete delayed")
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .delay(2000, TimeUnit.MILLISECONDS)
            .toObservable()
    }
}