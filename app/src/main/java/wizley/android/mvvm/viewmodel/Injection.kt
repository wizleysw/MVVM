package wizley.android.mvvm.viewmodel

import androidx.lifecycle.ViewModelProvider
import wizley.android.mvvm.model.UserRepository

object Injection {
    private val repository = UserRepository()
    private val userViewModelFactory = UserViewModelFactory(repository)

    fun ProvideUserViewodelFactory(): ViewModelProvider.Factory {
        return userViewModelFactory
    }
}