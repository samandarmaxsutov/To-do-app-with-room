package uz.it_school_.todoappwithroom.presenter.viewmodels

import androidx.lifecycle.LiveData
import uz.it_school_.todoappwithroom.data.room.entites.DoingEntity
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity

interface DoingViewModel {
    val getAllLiveData:LiveData<List<DoingEntity>>
    val openDialogLiveData:LiveData<ToDoEntity>
    fun insert(entity: DoingEntity)
    fun delete(entity: DoingEntity)
    fun update(entity: DoingEntity)
    fun addDone(entity:ToDoEntity)
    fun openDilaog(open: ToDoEntity)
}