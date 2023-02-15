package uz.it_school_.todoappwithroom.presenter.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school_.todoappwithroom.data.repository.impl.MainRepositoryImpl
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity
import uz.it_school_.todoappwithroom.presenter.viewmodels.ToDoViewModel
import uz.it_school_.todoappwithroom.utils.toDoingEntity

class ToDoViewModelImpl : ToDoViewModel,ViewModel() {
    private val  repositoryImpl= MainRepositoryImpl.getInstance()
    override val getAllLiveData=repositoryImpl.getToDoAll()
    override val openDialogLiveData=MutableLiveData<ToDoEntity>()

    override fun insert(entity: ToDoEntity) {
       repositoryImpl.insertToDo(entity)
    }

    override fun delete(entity: ToDoEntity) {
       repositoryImpl.deleteToDo(entity)
    }

    override fun update(entity: ToDoEntity) {
       repositoryImpl.updateToDo(entity)
    }

    override fun openDilaog(open: ToDoEntity) {
        openDialogLiveData.value=open
    }

    override fun addDoing(entity: ToDoEntity) {
        repositoryImpl.insertDoing(entity.toDoingEntity())
    }


}