package uz.it_school_.todoappwithroom.presenter.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school_.todoappwithroom.data.repository.impl.MainRepositoryImpl
import uz.it_school_.todoappwithroom.data.room.entites.DoneEntity
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity
import uz.it_school_.todoappwithroom.presenter.viewmodels.DoneViewModel

class DoneViewModelImpl : DoneViewModel,ViewModel()  {
    private val  repositoryImpl=MainRepositoryImpl.getInstance()
    override val getAllLiveData=repositoryImpl.getDoneAll()
    override val openDialogLiveData= MutableLiveData<ToDoEntity>()

    override fun insert(entity: DoneEntity) {
        repositoryImpl.insertDone(entity)
    }

    override fun delete(entity: DoneEntity) {
        repositoryImpl.deleteDone(entity)
    }

    override fun update(entity: DoneEntity) {
        repositoryImpl.updateDone(entity)
    }
    override fun openDilaog(open: ToDoEntity) {
        openDialogLiveData.value=open
    }
}