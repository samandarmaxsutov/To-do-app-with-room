package uz.it_school_.todoappwithroom.utils

import uz.it_school_.todoappwithroom.data.room.entites.DoingEntity
import uz.it_school_.todoappwithroom.data.room.entites.DoneEntity
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity

fun ToDoEntity.toDoingEntity():DoingEntity{
    return DoingEntity(this.id,this.title,this.describtion,this.date)
}
fun ToDoEntity.toDoneEntity(): DoneEntity {
    return DoneEntity(this.id,this.title,this.describtion,this.date)
}

fun DoingEntity.toToDoEntity():ToDoEntity{
    return ToDoEntity(this.id,this.title,this.describtion,this.date)
}
fun DoneEntity.toToDoEntity():ToDoEntity{
    return ToDoEntity(this.id,this.title,this.description,this.date)
}