package com.study.mvvm_study_2022.domain

import java.util.*

data class Diary(
    val id: String,
    val title: String,
    val content: String,
    val createDate: Date
)
