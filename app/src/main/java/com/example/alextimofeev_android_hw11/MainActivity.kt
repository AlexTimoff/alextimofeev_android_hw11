package com.example.alextimofeev_android_hw11

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alextimofeev_android_hw11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var repository : Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        repository = Repository(this)

        binding.customText.text=repository.getText()

       //Слушатель для кнопки сохранения введенного текста
        binding.saveButton.setOnClickListener {
            val text = binding.editText.text.toString()
            repository.saveText(text)
            binding.customText.text = repository.getText()
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show()
        }


        //Слушатель для кнопки удаления введенного текста
        binding.clearButton.setOnClickListener {
            repository.clearText()
            binding.editText.text?.clear()
            binding.customText.text = ""
            Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show()

        }

    }
}
