package com.nnapps.birthdayapp.domain.useCases

import com.nnapps.birthdayapp.domain.model.ContactsResponse
import com.nnapps.birthdayapp.domain.repository.ContactRepository
import retrofit2.Response
import javax.inject.Inject

class ContactsUseCaseImpl @Inject constructor(
    private val contactsRepository: ContactRepository,
) : ContactsUseCase {
    override suspend fun getContacts(): Response<ContactsResponse> {
        return contactsRepository.getContacts()
    }
}