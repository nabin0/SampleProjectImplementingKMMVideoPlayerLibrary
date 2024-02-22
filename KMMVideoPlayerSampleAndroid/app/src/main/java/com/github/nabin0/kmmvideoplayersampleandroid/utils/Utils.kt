package com.github.nabin0.kmmvideoplayersampleandroid.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {
    fun getFormattedDateTime(): String{
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(currentDate)
    }
}