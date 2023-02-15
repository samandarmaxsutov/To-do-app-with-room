package uz.it_school_.todoappwithroom.presenter.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.it_school_.todoappwithroom.data.repository.impl.IntroRepositoryImpl
import uz.it_school_.todoappwithroom.presenter.viewmodels.SplashScreenViewModel

class SplashScreenViewModelImpl : SplashScreenViewModel,ViewModel() {

    val repository = IntroRepositoryImpl.getInstance()
    override val openMainScreenLiveData=MutableLiveData<Unit>()
    override val openIntroScreenLiveData=MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            delay(2000)
            if (repository.getIsFirst()) {
                openIntroScreenLiveData.value=Unit
            }
            else{
                openMainScreenLiveData.value = Unit
            }
        }

    }
}