package uz.it_school_.todoappwithroom.view.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import uz.it_school_.todoappwithroom.R
import uz.it_school_.todoappwithroom.presenter.viewmodels.SplashScreenViewModel
import uz.it_school_.todoappwithroom.presenter.viewmodels.impl.SplashScreenViewModelImpl

class SplashScreen:Fragment(R.layout.screen_splash) {
    private val viewModel:SplashScreenViewModel by viewModels<SplashScreenViewModelImpl>()
    private val navController :NavController by lazy { findNavController() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openIntroScreenLiveData.observe(this){
            navController.navigate(SplashScreenDirections.actionSplashScreenToIntroScreen())
        }
        viewModel.openMainScreenLiveData.observe(this){
            navController.navigate(SplashScreenDirections.actionSplashScreenToMainScreen())
        }
    }
}