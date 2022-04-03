package com.study.mvvm_study_2022.presentation.diary.edit

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.study.mvvm_study_2022.databinding.ActivityEditDiaryBinding
import com.study.mvvm_study_2022.domain.Diary
import java.util.*

class EditDiaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditDiaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val diary = Diary(
            id = "2000",
            title = "제목",
            content = "내용",
            createDate = Date()
        )

        binding.bindingString = "제에에에에에모고오오오ㅗㄱ"
        binding.diary = diary
        binding.bindingInt = 5

        binding.buttonSubmit.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

    companion object {
        const val KEY_DIARY = "KEY_DIARY"
    }
}