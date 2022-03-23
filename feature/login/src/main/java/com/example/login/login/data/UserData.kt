package com.example.login.login.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserData(
    var name: String,
    var surname: String
) : Parcelable