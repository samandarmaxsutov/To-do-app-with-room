package uz.it_school_.todoappwithroom.presenter.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school_.todoappwithroom.data.repository.impl.MainRepositoryImpl
import uz.it_school_.todoappwithroom.data.room.entites.DoingEntity
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity
import uz.it_school_.todoappwithroom.presenter.viewmodels.DoingViewModel
import uz.it_school_.todoappwithroom.utils.toDoneEntity

class DoingViewModelImpl : DoingViewModel, ViewModel()  {
    private val  repositoryImpl= MainRepositoryImpl.getInstance()
    override val getAllLiveData=repositoryImpl.getDoingAll()
    override val openDialogLiveData=MutableLiveData<ToDoEntity>()


    override fun insert(entity: DoingEntity) {
        repositoryImpl.insertDoing(entity)
    }

    override fun delete(entity: DoingEntity) {
        repositoryImpl.deleteDoing(entity)
    }

    override fun update(entity: DoingEntity) {
        repositoryImpl.updateDoing(entity)
    }

    override fun addDone(entity: ToDoEntity) {
        repositoryImpl.insertDone(entity.toDoneEntity())
    }

    override fun openDilaog(open: ToDoEntity) {
        openDialogLiveData.value=open
    }
}