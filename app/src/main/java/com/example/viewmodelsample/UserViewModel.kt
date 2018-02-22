package com.example.viewmodelsample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log

data class User(val name: String, val age: Int)

class UserViewModel : ViewModel() {

    private var user: MutableLiveData<User>? = null

    fun getUser(): MutableLiveData<User>? {
        if (user == null) {
            user = MutableLiveData()
            load()
        }
        return user
    }

    private fun load() {
        user?.postValue(User("Hanyu", 23))
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("UserViewModel", "onCleared")
    }
}
