package uz.it_school_.todoappwithroom.presenter.viewmodels

import androidx.lifecycle.LiveData

interface SplashScreenViewModel {
    val openMainScreenLiveData:LiveData<Unit>
    val openIntroScreenLiveData:LiveData<Unit>
}