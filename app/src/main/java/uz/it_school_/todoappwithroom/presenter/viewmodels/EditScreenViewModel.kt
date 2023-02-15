package uz.it_school_.todoappwithroom.presenter.viewmodels

import androidx.lifecycle.LiveData

interface EditScreenViewModel {

    val saveLiveData:LiveData<String>
    val backLiveData:LiveData<Unit>
    fun save(id:Int,title:String,des:String,data:String)
    fun back()
}