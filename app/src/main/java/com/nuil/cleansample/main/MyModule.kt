package com.nuil.cleansample.main

import com.nuil.cleansample.main.data.ItemsRepositoryImpl
import com.nuil.cleansample.main.domain.repository.ItemsRepository
import com.nuil.cleansample.main.domain.usecase.AddItem
import com.nuil.cleansample.main.domain.usecase.DeleteItem
import com.nuil.cleansample.main.presentation.main.MainViewModel
import org.koin.dsl.module

val myDiModule = module {

    factory<ItemsRepository> { ItemsRepositoryImpl() }
    //val repo : ItemsRepository = ItemsRepositoryImpl()

    factory { AddItem(get()) }
    factory { DeleteItem(get()) }

    // viewmodel usecase
    factory {
        MainViewModel(
            get(),
            get()
        )
    }
}

val accountModule = module {

}

val productModule=  module {

}