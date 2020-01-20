package com.nuil.cleansample.main.data

import com.nuil.cleansample.main.entity.ItemEntity

fun ItemEntity.transform(): Item = Item(this.title, this.dateTime)

fun Item.transform(): ItemEntity = ItemEntity(this.title, this.dateTime)