package uz.it_school_.todoappwithroom.data.room.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DoneEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    var title:String,
    var description:String,
    var date:String
)