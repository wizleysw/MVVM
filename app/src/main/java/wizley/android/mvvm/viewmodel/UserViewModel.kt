package wizley.android.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import wizley.android.mvvm.model.User
import wizley.android.mvvm.model.UserRepository

class UserViewModel(private val userRepository: UserRepository): ViewModel(){

    private val users = MutableLiveData<List<User>>().apply {
        value = emptyList()
    }

    var user =  MutableLiveData<User>()

    fun fetchUser(){
        user.value = userRepository.fetchUser()
    }

}