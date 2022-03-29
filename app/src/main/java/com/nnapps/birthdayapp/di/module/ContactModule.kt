package com.nnapps.birthdayapp.di.module

import com.nnapps.birthdayapp.domain.useCases.ContactsUseCase
import com.nnapps.birthdayapp.domain.useCases.ContactsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ContactModule {
    @Binds
    abstract fun bindContactsUseCase(contactsUseCase: ContactsUseCaseImpl): ContactsUseCase
}