package uz.it_school_.todoappwithroom.data.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import uz.it_school_.todoappwithroom.data.room.entites.DoneEntity
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity

@Dao
interface DoneDoa {
    @Query("select * from DoneEntity")
    fun getAll(): LiveData<List<DoneEntity>>
    @Insert
    fun insert(data: DoneEntity)

    @Delete
    fun delete(data: DoneEntity)

    @Update
    fun update(data: DoneEntity)
}