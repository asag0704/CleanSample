package com.nuil.cleansample.main.data

import com.nuil.cleansample.main.domain.repository.ItemsRepository
import com.nuil.cleansample.main.entity.ItemEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ItemsRepositoryImpl : ItemsRepository {
    override fun addItem(string: String): Single<ItemEntity> {
        return Single.create<ItemEntity> { emitter ->
            val item = ItemModel("Add", System.currentTimeMillis())
            emitter.onSuccess(item.transform())
        }
            .delay(2000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun deleteItem(): Single<ItemEntity> {
        return Single.create<ItemEntity> { emitter ->
            val item = ItemModel("Delete", System.currentTimeMillis())
            emitter.onSuccess(item.transform())
        }
            .delay(2000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}