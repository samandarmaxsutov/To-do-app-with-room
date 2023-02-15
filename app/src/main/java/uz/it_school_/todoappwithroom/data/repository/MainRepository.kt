package uz.it_school_.todoappwithroom.data.repository

import androidx.lifecycle.LiveData
import uz.it_school_.todoappwithroom.data.room.entites.DoingEntity
import uz.it_school_.todoappwithroom.data.room.entites.DoneEntity
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity

interface MainRepository {
    fun getToDoAll():LiveData<List<ToDoEntity>>
    fun getDoneAll():LiveData<List<DoneEntity>>
    fun getDoingAll():LiveData<List<DoingEntity>>

    fun insertToDo(entity: ToDoEntity)
    fun insertDone(entity: DoneEntity)
    fun insertDoing(entity: DoingEntity)

    fun deleteToDo(entity: ToDoEntity)
    fun deleteDone(entity: DoneEntity)
    fun deleteDoing(entity: DoingEntity)

    fun updateToDo(entity: ToDoEntity)
    fun updateDone(entity: DoneEntity)
    fun updateDoing(entity: DoingEntity)

}