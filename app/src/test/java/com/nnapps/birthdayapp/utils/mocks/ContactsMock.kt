package com.nnapps.birthdayapp.utils.mocks

import com.nnapps.birthdayapp.domain.model.Contact
import com.nnapps.birthdayapp.domain.model.ContactsResponse
import com.nnapps.birthdayapp.domain.model.DateOfBirth
import com.nnapps.birthdayapp.domain.model.Name

class ContactsMock {
    companion object {
        private val nameMock = Name(
            title = "Miss",
            firstName = "TestFirstName",
            lastName = "TestLastName",
        )
        private val dobMock = DateOfBirth(
            date = "1980-00-10T00:00+00:00Z",
            age = 24
        )
        private val contactMock = Contact(
            name = nameMock,
            dob = dobMock
        )
        val contactsMock = ContactsResponse(
            mutableListOf(contactMock)
        )
    }
}