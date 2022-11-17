package uz.salimovdeveloper.valyutakurslari.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.salimovdeveloper.valyutakurslari.R
import uz.salimovdeveloper.valyutakurslari.databinding.FragmentConverterBinding

class ConverterFragment : Fragment() {
    private lateinit var binding: FragmentConverterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConverterBinding.inflate(layoutInflater)

        return binding.root
    }

}