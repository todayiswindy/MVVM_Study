package com.study.mvvm_study_2022.presentation.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("app:createdDate")
fun bindCreateDate(textView: TextView, date: Date?) {
    if (date == null) return
    val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd", Locale.KOREA)
    textView.text = simpleDateFormat.format(date)
}