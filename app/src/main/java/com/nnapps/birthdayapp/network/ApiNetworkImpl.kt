package com.nnapps.birthdayapp.network

import com.nnapps.birthdayapp.domain.model.ContactsResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiNetworkImpl @Inject constructor(
    private val birthdayService: BirthdayService
) :
    ApiNetwork {
    override suspend fun getContacts(): Response<ContactsResponse> {
        return birthdayService.getContacts()
    }
}