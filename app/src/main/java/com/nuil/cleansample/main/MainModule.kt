package com.nuil.cleansample.main

import com.nuil.cleansample.main.data.ItemsRepositoryImpl
import com.nuil.cleansample.main.domain.repository.ItemsRepository
import com.nuil.cleansample.main.domain.usecase.AddItem
import com.nuil.cleansample.main.domain.usecase.DeleteItem
import com.nuil.cleansample.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory<ItemsRepository> { ItemsRepositoryImpl() }
    //val repo : ItemsRepository = ItemsRepositoryImpl()

    factory { AddItem(get()) }
    factory { DeleteItem(get()) }

    // viewmodel usecase
    viewModel {
        MainViewModel(
            get(),
            get()
        )
    }
}