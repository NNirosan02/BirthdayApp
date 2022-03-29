package com.nnapps.birthdayapp.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    @SerializedName("name")
    val name: Name,
    @SerializedName("dob")
    val dob: DateOfBirth
) : Parcelable