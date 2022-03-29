package com.nnapps.birthdayapp.domain.useCases

import com.nnapps.birthdayapp.domain.model.ContactsResponse
import retrofit2.Response

interface ContactsUseCase {
    suspend fun getContacts(): Response<ContactsResponse>
}