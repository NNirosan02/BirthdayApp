package com.nnapps.birthdayapp.domain.repository

import com.nnapps.birthdayapp.domain.model.ContactsResponse
import retrofit2.Response

interface ContactRepository {
    suspend fun getContacts(): Response<ContactsResponse>
}