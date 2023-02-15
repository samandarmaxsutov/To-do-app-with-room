package uz.it_school_.todoappwithroom.presenter.viewmodels

import androidx.lifecycle.LiveData
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity

interface ToDoViewModel {
    val getAllLiveData:LiveData<List<ToDoEntity>>
    val openDialogLiveData:LiveData<ToDoEntity>
    fun insert(entity: ToDoEntity)
    fun delete(entity: ToDoEntity)
    fun update(entity: ToDoEntity)
    fun openDilaog(open:ToDoEntity)
    fun addDoing(entity: ToDoEntity)

}