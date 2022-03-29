package com.nnapps.birthdayapp.domain.repository

import com.nnapps.birthdayapp.domain.model.ContactsResponse
import com.nnapps.birthdayapp.network.ApiNetwork
import retrofit2.Response
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val apiNetwork: ApiNetwork
) : ContactRepository {
    override suspend fun getContacts(): Response<ContactsResponse> {
        return apiNetwork.getContacts()
    }
}
