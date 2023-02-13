package uz.it_school_.todoappwithroom.data.room.entities


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoEntity (
    @PrimaryKey
    val id:Int,
    val title:String,
    val description:String,
    val date:String,
    val completed:Boolean
    )

