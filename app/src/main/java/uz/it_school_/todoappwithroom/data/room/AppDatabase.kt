package uz.it_school_.todoappwithroom.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.it_school_.todoappwithroom.data.room.daos.ToDoDao
import uz.it_school_.todoappwithroom.data.room.entities.ToDoEntity


@Database(entities = [ToDoEntity::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    companion object{
        private var database:AppDatabase?=null


        fun init(context:Context){
            database= Room.databaseBuilder(context, AppDatabase::class.java,"appDatabase")
                .allowMainThreadQueries()
                .build()
        }

        fun getAppDatabase()= database!!
    }

    abstract fun getTodoDao():ToDoDao


}