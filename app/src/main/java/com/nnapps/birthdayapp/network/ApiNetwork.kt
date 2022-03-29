package com.nnapps.birthdayapp.network

import com.nnapps.birthdayapp.domain.model.ContactsResponse
import retrofit2.Response

interface ApiNetwork {
    suspend fun getContacts(): Response<ContactsResponse>
}