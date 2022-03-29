package com.nnapps.birthdayapp.utils

import java.text.SimpleDateFormat
import java.util.Locale

class DateUtil {
    companion object {
        fun getDayMonthYearAsString(dateAsString: String): String {
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = formatter.parse(dateAsString)
            return SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(date) as String
        }
    }
}