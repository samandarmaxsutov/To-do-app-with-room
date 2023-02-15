package uz.it_school_.todoappwithroom.data.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import uz.it_school_.todoappwithroom.data.room.entites.DoingEntity
import uz.it_school_.todoappwithroom.data.room.entites.DoneEntity
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity

@Dao
interface  DoingDao {
    @Query("select * from DoingEntity")
    fun getAll(): LiveData<List<DoingEntity>>
    @Insert
    fun insert(data: DoingEntity)

    @Delete
    fun delete(data: DoingEntity)

    @Update
    fun update(data: DoingEntity)
}