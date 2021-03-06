package com.study.mvvm_study_2022.presentation.diary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.study.mvvm_study_2022.databinding.ActivityDiariesBinding
import com.study.mvvm_study_2022.domain.Diary
import com.study.mvvm_study_2022.presentation.diary.edit.EditDiaryActivity
import java.util.*

class DiariesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiariesBinding
    private lateinit var diariesAdapter: DiariesAdapter

    private lateinit var editDiaryActivityLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        editDiaryActivityLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                onEditMemoFinished(it)
            }
        initView()

        diariesAdapter.submitList(STUB_DIARIES)
    }

    private fun initView() {
        binding = ActivityDiariesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listDiaries.adapter = DiariesAdapter(::onMemoClick).also { diariesAdapter = it }
        binding.buttonNewDiary.setOnClickListener { deployEditDiaryActivity() }
    }

    private fun onMemoClick(diary: Diary) {
        deployEditDiaryActivity(diary)
    }

    private fun deployEditDiaryActivity(diary: Diary? = null) {
        val intent = Intent(this, EditDiaryActivity::class.java)
        if (diary != null) {
            intent.putExtra(EditDiaryActivity.KEY_DIARY, diary.id)
        }
        editDiaryActivityLauncher.launch(intent)
    }

    private fun onEditMemoFinished(result: ActivityResult) = when (result.resultCode) {
        Activity.RESULT_OK -> showToast("작성 완료!")
        Activity.RESULT_CANCELED -> showToast("작성이 취소되었습니다.")
        else -> showToast("Unexpected Activity Result : $result")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        val STUB_DIARIES = listOf(
            Diary("0", "제목", "내용", Date()),
            Diary("1", "제목", "내용", Date()),
            Diary("2", "제목", "내용", Date()),
            Diary("3", "제목", "내용", Date()),
            Diary("4", "제목", "내용", Date()),
        )
    }
}