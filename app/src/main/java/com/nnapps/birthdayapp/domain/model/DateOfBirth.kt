package com.nnapps.birthdayapp.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DateOfBirth(
    @SerializedName("date")
    var date: String,
    @SerializedName("age")
    val age: Int
) : Parcelable
