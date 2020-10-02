package wizley.android.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import wizley.android.mvvm.R
import wizley.android.mvvm.databinding.ActivityUserBinding
import wizley.android.mvvm.viewmodel.Injection
import wizley.android.mvvm.viewmodel.UserViewModel

class UserActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user)
        initViewModel()
    }

    override fun onResume() {
        super.onResume()

        // Command Pattern
        viewModel.fetchUser()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this,
            Injection.ProvideUserViewodelFactory()).get(UserViewModel::class.java)
        dataBinding.vm = viewModel
    }
}