package com.nnapps.birthdayapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.nnapps.birthdayapp.R
import com.nnapps.birthdayapp.data.ContactsViewModel
import com.nnapps.birthdayapp.databinding.FragmentContactsBinding
import com.nnapps.birthdayapp.domain.model.Contact
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_contacts.view.rv_contacts

@AndroidEntryPoint
class ContactsFragment : Fragment(),
    ContactsRvAdapter.ItemClickListener {

    lateinit var mainViewModel: ContactsViewModel
    lateinit var navController: NavController
    private lateinit var contactsListLinearLayoutManager: LinearLayoutManager
    private lateinit var contactsRvAdapter: ContactsRvAdapter
    private lateinit var contactsFragmentBinding: FragmentContactsBinding
    private var contactsList: MutableList<Contact> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this)[ContactsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        contactsFragmentBinding = FragmentContactsBinding.inflate(inflater, container, false)
        navController = findNavController()
        contactsList = mutableListOf()
        setUpData()
        setUpObservables()
        setupRecycler()
        return contactsFragmentBinding.root
    }

    private fun setupRecycler() {
        val contactsListRoot = contactsFragmentBinding.root
        contactsListLinearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        contactsRvAdapter = ContactsRvAdapter(contactsList, this)
        contactsListRoot.rv_contacts.layoutManager = contactsListLinearLayoutManager
        contactsListRoot.rv_contacts.adapter = contactsRvAdapter
    }

    private fun setUpData() {
        getContacts()
    }

    private fun getContacts() {
        mainViewModel.getContacts()
    }

    private fun setUpObservables() {
        mainViewModel.contacts.observe(viewLifecycleOwner) { contacts ->
            contactsList.clear()
            contactsList.addAll(contacts)
            contactsRvAdapter.updateContacts(contactsList)
        }
        mainViewModel.unSuccessfulCall.observe(viewLifecycleOwner) { unSuccessful ->
            if (unSuccessful) {
                showErrorDialog()
            }
        }

        mainViewModel.loadingAnimVisibility.observe(viewLifecycleOwner) { show ->
            if (show) {
                contactsFragmentBinding.loadingView.visibility = View.VISIBLE
            } else {
                contactsFragmentBinding.loadingView.visibility = View.GONE
            }
        }
    }

    private fun showErrorDialog() {
        var alertMessage = getString(R.string.txt_something_went_wrong)
        MaterialAlertDialogBuilder(layoutInflater.context)
            .setTitle(R.string.txt_error)
            .setMessage(alertMessage)
            .setPositiveButton(resources.getString(R.string.txt_close)) { _, _ ->

            }
            .setNegativeButton(resources.getString(R.string.txt_retry)) { _, _ ->
                getContacts()
            }
            .show()
    }

    override fun itemClickListener(contact: Contact) {
        val action =
            ContactsFragmentDirections.actionContactsFragmentToContactDetailFragment(
                contact
            )
        navController.navigate(action)
    }
}