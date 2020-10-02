# MVVM

This is example of MVVM pattern in Android using kotlin.

## Dev note

Dev details are written in Korean. 

https://bughunting.kr/android/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%9C%EB%B0%9C%EC%97%90-%EC%82%AC%EC%9A%A9%EB%90%98%EB%8A%94-MVP-MVVM-%ED%8C%A8%ED%84%B4/

## What is MVP Pattern ??

Model : is to store data
View : deals with UI. data binding is recommended
ViewModel : deals with business logic

### Model

```kotlin
data class User(
    val name: String,
    val age: Int
)
```

### View

```kotlin
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
```

### ViewModel

```kotlin
class UserViewModel(private val userRepository: UserRepository): ViewModel(){

    private val users = MutableLiveData<List<User>>().apply {
        value = emptyList()
    }

    var user =  MutableLiveData<User>()

    fun fetchUser(){
        user.value = userRepository.fetchUser()
    }

}
```

### data binding

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>
        <variable
            name="vm"
            type="wizley.android.mvvm.viewmodel.UserViewModel" />
    </data>

   <LinearLayout
       android:orientation="vertical"
       android:layout_width="match_parent"
       android:layout_height="match_parent">

       <TextView
           android:layout_width="match_parent"
           android:layout_height="wrap_content"
           android:layout_gravity="center"
           android:text="@{vm.user.name}"
           android:id="@+id/name"/>

       <TextView
           android:layout_width="match_parent"
           android:layout_height="wrap_content"
           android:layout_gravity="center"
           android:text="@{Integer.toString(vm.user.age)}"
           android:id="@+id/age"/>
   </LinearLayout>


</layout>

```

## Pros and Cons

pros : UI and business logic is seperated

cons : if view model is huge, more memory is consumed


