package wizley.android.mvvm.model

import androidx.lifecycle.LiveData

class UserRepository {
    fun fetchUser() : User{
        return User("Wizley", 1)
    }
}