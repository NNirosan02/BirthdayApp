package com.nnapps.birthdayapp.domain.model

import com.google.gson.annotations.SerializedName

data class ContactsResponse(
    @SerializedName("results")
    val contacts: MutableList<Contact>
)