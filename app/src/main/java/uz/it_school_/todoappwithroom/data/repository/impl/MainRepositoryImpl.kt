package uz.it_school_.todoappwithroom.data.repository.impl

import androidx.lifecycle.LiveData
import uz.it_school_.todoappwithroom.data.repository.IntroRepository
import uz.it_school_.todoappwithroom.data.repository.MainRepository
import uz.it_school_.todoappwithroom.data.room.AppDatabase
import uz.it_school_.todoappwithroom.data.room.entites.DoingEntity
import uz.it_school_.todoappwithroom.data.room.entites.DoneEntity
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity

class MainRepositoryImpl : MainRepository {
    private val appDatabase=AppDatabase.getInstance()
    private val toDoDao=appDatabase.getTodoDao()
    private val doneDoa=appDatabase.getDoneDao()
    private val doingDao=appDatabase.getDoingDao()

    companion object {
        private var mainRepository: MainRepository?=null
        fun init(){
            if (mainRepository==null){
                mainRepository= MainRepositoryImpl()
            }
        }
        fun getInstance()= mainRepository!!
    }


    override fun getToDoAll(): LiveData<List<ToDoEntity>> {
        return toDoDao.getAll()
    }

    override fun getDoneAll(): LiveData<List<DoneEntity>> {
        return doneDoa.getAll()
    }

    override fun getDoingAll(): LiveData<List<DoingEntity>> {
        return doingDao.getAll()
    }


    override fun insertToDo(entity: ToDoEntity) {
        toDoDao.insert(entity)
    }

    override fun insertDone(entity: DoneEntity) {
        doneDoa.insert(entity)
    }

    override fun insertDoing(entity: DoingEntity) {
        doingDao.insert(entity)
    }

    override fun deleteToDo(entity: ToDoEntity) {
        toDoDao.delete(entity)
    }

    override fun deleteDone(entity: DoneEntity) {
        doneDoa.delete(entity)
    }

    override fun deleteDoing(entity: DoingEntity) {
        doingDao.delete(entity)
    }

    override fun updateToDo(entity: ToDoEntity) {
        toDoDao.update(entity)
    }

    override fun updateDone(entity: DoneEntity) {
        doneDoa.update(entity)
    }

    override fun updateDoing(entity: DoingEntity) {
        doingDao.update(entity)
    }
}