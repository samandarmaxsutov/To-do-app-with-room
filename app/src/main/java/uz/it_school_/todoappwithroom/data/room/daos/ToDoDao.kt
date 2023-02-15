package uz.it_school_.todoappwithroom.data.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity

@Dao
interface  ToDoDao {
    @Query("select * from ToDoEntity")
    fun getAll():LiveData<List<ToDoEntity>>
    @Insert
    fun insert(data:ToDoEntity)

    @Delete
    fun delete(data:ToDoEntity)

    @Update
    fun update(data:ToDoEntity)

}