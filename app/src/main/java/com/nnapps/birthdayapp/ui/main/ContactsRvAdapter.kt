package com.nnapps.birthdayapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nnapps.birthdayapp.databinding.ContactItemBinding
import com.nnapps.birthdayapp.domain.model.Contact

class ContactsRvAdapter(
    private var contactsList: MutableList<Contact>,
    private val clickListener: ItemClickListener
) : RecyclerView.Adapter<ContactsRvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    fun updateContacts(newContactsList: MutableList<Contact>) {
        this.contactsList = newContactsList
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contactsList[position]
        val contactName = "${item.name.title} ${item.name.firstName} ${item.name.lastName}"
        holder.itemView.setOnClickListener { clickListener.itemClickListener(item) }
        holder.binding.tvName.text = contactName
        holder.binding.tvDob.text = item.dob.date
        holder.binding.tvYears.text = item.dob.age.toString()
        holder.binding.executePendingBindings()
    }

    inner class ViewHolder(val binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root)
    interface ItemClickListener {
        fun itemClickListener(contact: Contact)
    }
}
