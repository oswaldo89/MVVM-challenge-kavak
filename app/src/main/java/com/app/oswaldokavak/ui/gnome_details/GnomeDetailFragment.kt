package com.app.oswaldokavak.ui.gnome_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.oswaldokavak.data.model.Brastlewark
import com.app.oswaldokavak.databinding.FragmentGnomeDetailBinding
import com.app.oswaldokavak.utils.extensions_functions.loadurl

class GnomeDetailFragment : Fragment() {

    private var _binding: FragmentGnomeDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var gnome : Brastlewark

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            gnome = it.getParcelable("gnome")!!
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {
        _binding = FragmentGnomeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtName.text = gnome.name
        binding.txtAge.text = "${gnome.age}"
        binding.rivProfile.loadurl(gnome.thumbnail)
    }
}