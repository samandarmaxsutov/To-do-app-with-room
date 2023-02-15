package uz.it_school_.todoappwithroom.presenter.viewmodels

import androidx.lifecycle.LiveData

interface AddScreenViewModel {

    val saveLiveData:LiveData<String>
    val backLiveData:LiveData<Unit>
    fun save(title:String,des:String,data:String)
    fun back()
}