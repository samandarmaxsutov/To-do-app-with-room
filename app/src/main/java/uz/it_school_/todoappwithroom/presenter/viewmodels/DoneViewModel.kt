package uz.it_school_.todoappwithroom.presenter.viewmodels

import androidx.lifecycle.LiveData
import uz.it_school_.todoappwithroom.data.room.entites.DoneEntity
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity

interface DoneViewModel {
    val getAllLiveData:LiveData<List<DoneEntity>>
    val openDialogLiveData:LiveData<ToDoEntity>
    fun insert(entity: DoneEntity)
    fun delete(entity: DoneEntity)
    fun update(entity: DoneEntity)
    fun openDilaog(open: ToDoEntity)
}