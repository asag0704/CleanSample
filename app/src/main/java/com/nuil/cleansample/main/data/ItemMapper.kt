package com.nuil.cleansample.main.data

import com.nuil.cleansample.main.entity.ItemEntity

/**
 * DataMapper
 */

fun ItemModel.transform(): ItemEntity = ItemEntity(this.title, this.currentTime)