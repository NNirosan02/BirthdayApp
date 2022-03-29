package com.nnapps.birthdayapp.domain.repository

import com.google.common.truth.Truth
import com.nnapps.birthdayapp.network.ApiNetworkImpl
import com.nnapps.birthdayapp.utils.mocks.ContactsMock
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class ContactRepositoryImplTest {

    @RelaxedMockK
    private lateinit var apiNetworkImpl: ApiNetworkImpl

    private lateinit var repository: ContactRepositoryImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = ContactRepositoryImpl(apiNetworkImpl)
    }

    @Test
    fun `getContacts success`() = runBlockingTest {
        val outcome = ContactsMock.contactsMock

        coEvery { apiNetworkImpl.getContacts() } returns Response.success(outcome)

        val repoResponse = repository.getContacts()

        Truth.assertThat(repoResponse.isSuccessful).isEqualTo(true)
        Truth.assertThat(repoResponse.body()).isEqualTo(outcome)
    }
}