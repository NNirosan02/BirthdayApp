package com.nnapps.birthdayapp.ui.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.nnapps.birthdayapp.databinding.FragmentContactDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactDetailFragment : Fragment() {

    private lateinit var contactDetailFragmentBinding: FragmentContactDetailBinding
    val args: ContactDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        contactDetailFragmentBinding =
            FragmentContactDetailBinding.inflate(inflater, container, false)
        contactDetailFragmentBinding.contact = args.contact
        return contactDetailFragmentBinding.root
    }

}