package com.d3if4065.luassegitiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.d3if4065.luassegitiga.databinding.ActivityMainBinding
import com.d3if4065.luassegitiga.model.hasilLuas
import com.d3if4065.luassegitiga.ui.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater())
        setContentView(binding.root)

        binding.buttonHitung.setOnClickListener { hitungLuas() }
        binding.buttonReset.setOnClickListener { resetButton() }
    }

    private fun hitungLuas() {

        val Alas = binding.alasInputNumber.text.toString()
        if (TextUtils.isEmpty(Alas)) {
            Toast.makeText(this, R.string.Alas_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val Tinggi = binding.tinggiInputNumber.text.toString()
        if (TextUtils.isEmpty(Tinggi)) {
            Toast.makeText(this, R.string.Tinggi_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val hasil = 0.5 * Alas.toFloat() * Tinggi.toFloat()
        binding.hasilLuas.text = getString(R.string.hasilLuas_X, hasil)

        val result = viewModel.luasHitung(
            Alas.toFloat(),
            Tinggi.toFloat()
        )
        showResult(result)
    }

    private fun showResult(result:hasilLuas){
        binding.hasilLuas.text = getString(R.string.hasilLuas_X, result.luas)
    }

    private fun resetButton(){

        binding.alasInputNumber.setText("")
        binding.tinggiInputNumber.setText("")
        binding.hasilLuas.setText("")
    }
}

