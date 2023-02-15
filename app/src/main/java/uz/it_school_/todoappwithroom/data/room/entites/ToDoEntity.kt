package uz.it_school_.todoappwithroom.data.room.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    var title:String,
    var describtion:String,
    var date:String
):Serializable