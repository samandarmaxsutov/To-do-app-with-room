package uz.it_school_.todoappwithroom.presenter.viewmodels

import androidx.lifecycle.LiveData
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity

interface MainScreenViewModel {
    val openAddScreenLiveData: LiveData<Unit>
    val openReadScreenLiveData: LiveData<ToDoEntity>
    fun openAddScreen()
    fun openRead(entity:ToDoEntity)
    val openEditLiveData:LiveData<ToDoEntity>
    fun openEditScreen(entity: ToDoEntity)

}