package uz.it_school_.todoappwithroom.presenter.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity
import uz.it_school_.todoappwithroom.presenter.viewmodels.MainScreenViewModel

class MainScreenViewModelImpl : MainScreenViewModel,ViewModel(){
    override val openAddScreenLiveData= MutableLiveData<Unit>()
    override val openReadScreenLiveData=MutableLiveData<ToDoEntity>()
    override val openEditLiveData=MutableLiveData<ToDoEntity>()


    override fun openAddScreen() {
        openAddScreenLiveData.value=Unit
    }

    override fun openRead(entity: ToDoEntity) {
       openReadScreenLiveData.value=entity
    }



    override fun openEditScreen(entity: ToDoEntity) {
        openEditLiveData.value=entity
    }
}