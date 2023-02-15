package uz.it_school_.todoappwithroom.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.it_school_.todoappwithroom.data.room.daos.DoingDao
import uz.it_school_.todoappwithroom.data.room.daos.DoneDoa
import uz.it_school_.todoappwithroom.data.room.daos.ToDoDao
import uz.it_school_.todoappwithroom.data.room.entites.DoingEntity
import uz.it_school_.todoappwithroom.data.room.entites.DoneEntity
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity


@Database (entities = [
    ToDoEntity::class,
    DoingEntity::class,
    DoneEntity::class ], version = 1)
abstract class AppDatabase :RoomDatabase() {
    companion object{
        private  var appDatabase:AppDatabase?=null
        fun init(context: Context){
            if (appDatabase==null){
                appDatabase= Room.databaseBuilder(context,AppDatabase::class.java,"appDatabse")
                    .allowMainThreadQueries()
                    .build()
            }
        }
        fun getInstance()= appDatabase!!
    }

  abstract  fun getTodoDao(): ToDoDao
  abstract  fun getDoneDao(): DoneDoa
  abstract  fun getDoingDao(): DoingDao
}