package com.nnapps.birthdayapp.network

import com.nnapps.birthdayapp.domain.model.ContactsResponse
import retrofit2.Response
import retrofit2.http.GET

interface BirthdayService {
    @GET("api/?results=20&seed=chalkboard&inc=name,dob")
    suspend fun getContacts(): Response<ContactsResponse>
}