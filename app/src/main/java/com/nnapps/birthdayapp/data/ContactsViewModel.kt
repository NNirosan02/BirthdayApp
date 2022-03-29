package com.nnapps.birthdayapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nnapps.birthdayapp.domain.model.Contact
import com.nnapps.birthdayapp.domain.useCases.ContactsUseCaseImpl
import com.nnapps.birthdayapp.utils.DateUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(
    private val contactsUseCase: ContactsUseCaseImpl
) : ViewModel() {

    private val _contacts: MutableLiveData<List<Contact>> = MutableLiveData()
    private val _unSuccessfulCall: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _loadingAnimVisibility: MutableLiveData<Boolean> = MutableLiveData(false)
    val contacts = _contacts
    val unSuccessfulCall: LiveData<Boolean> = _unSuccessfulCall
    val loadingAnimVisibility: LiveData<Boolean> = _loadingAnimVisibility

    fun getContacts() {
        viewModelScope.launch {
            _loadingAnimVisibility.postValue(true)
            val response = contactsUseCase.getContacts()
            if (response.isSuccessful) {
                val contactResponse = response.body()!!.contacts.sortedBy { it.dob.date }
                contactResponse.forEach {
                    it.dob.date = DateUtil.getDayMonthYearAsString(it.dob.date)
                }
                _contacts.postValue(contactResponse)
                _loadingAnimVisibility.postValue(false)
            } else {
                _unSuccessfulCall.postValue(true)
                _loadingAnimVisibility.postValue(false)
            }
        }
    }
}