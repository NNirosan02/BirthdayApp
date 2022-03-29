package com.nnapps.birthdayapp.di.module

import com.nnapps.birthdayapp.domain.repository.ContactRepository
import com.nnapps.birthdayapp.domain.repository.ContactRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindContactsRepository(contactRepository: ContactRepositoryImpl): ContactRepository
}
