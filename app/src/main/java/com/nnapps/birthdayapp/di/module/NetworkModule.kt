package com.nnapps.birthdayapp.di.module

import com.nnapps.birthdayapp.network.ApiNetwork
import com.nnapps.birthdayapp.network.ApiNetworkImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {
    @Binds
    abstract fun bindApiNetwork(apiNetwork: ApiNetworkImpl): ApiNetwork
}
