package uz.it_school_.todoappwithroom.presenter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface IntroScreenViewModel {
    val openMainScreenLiveData:LiveData<Unit>
    val nextPageLiveData:LiveData<Int>
    val positon:MutableLiveData<Int>
    fun nextPage(pos:Int)
}