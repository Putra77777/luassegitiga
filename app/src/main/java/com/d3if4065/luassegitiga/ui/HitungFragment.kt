package com.d3if4065.luassegitiga.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.d3if4065.luassegitiga.R
import com.d3if4065.luassegitiga.databinding.FragmentHitungBinding
import com.d3if4065.luassegitiga.model.HasilLuas

class HitungFragment : Fragment() {
    private lateinit var binding: FragmentHitungBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonHitung.setOnClickListener { HitungLuas() }
        binding.buttonReset.setOnClickListener { resetButton() }
        viewModel.getHasilLuas().observe(requireActivity()) { showResult(it) }
        binding.historyButton.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_hitungFragment_to_historyFragment
            )
        }
        setHasOptionsMenu(true)

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(
                R.id.action_hitungFragment_to_aboutFragment
            )
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun HitungLuas() {

        val alas = binding.alasInputNumber.text.toString()
        if (TextUtils.isEmpty(alas)) {
            Toast.makeText(context, "Alas tidak boleh kosong", Toast.LENGTH_LONG).show()
            return
        }
        val tinggi = binding.tinggiInputNumber.text.toString()
        if (TextUtils.isEmpty(tinggi)) {
            Toast.makeText(context, "Tinggi tidak boleh kosong", Toast.LENGTH_LONG).show()
            return
        }

        viewModel.luasHitung(
            alas.toDouble(),
            tinggi.toDouble()
        )

    }

    private fun showResult(result: HasilLuas?) {
        if (result == null) return
        binding.hasilLuas.text = result.hasil.toString()
    }

    private fun resetButton() {

        binding.alasInputNumber.text!!.clear()
        binding.tinggiInputNumber.text!!.clear()
        binding.hasilLuas.text = ""
    }
}

