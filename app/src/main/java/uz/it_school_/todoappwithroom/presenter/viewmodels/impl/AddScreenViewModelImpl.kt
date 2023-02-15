package uz.it_school_.todoappwithroom.presenter.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school_.todoappwithroom.data.repository.impl.MainRepositoryImpl
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity
import uz.it_school_.todoappwithroom.presenter.viewmodels.AddScreenViewModel

class AddScreenViewModelImpl : AddScreenViewModel,ViewModel() {
    val repositoryImpl=MainRepositoryImpl.getInstance()
    override val saveLiveData=MutableLiveData<String>()
    override val backLiveData=MutableLiveData<Unit>()

    override fun save(title: String, des: String, data: String) {

       if (!(title.isEmpty()||des.isEmpty()||data.isEmpty())){
           if (title.length>=6 && des.length>=20&&data.length>=8 ){
               repositoryImpl.insertToDo(ToDoEntity(0,title,des,data))
               back()
               saveLiveData.value="Ma'lumotlar saqlandi"

           }
           else{
               saveLiveData.value="Title kamida 6 ta belgi va Description  kamida 20 ta belgi bo'lishi kerak."
           }
       }
       else{
           saveLiveData.value="Title kamida 6 ta belgi va Description  kamida 20 ta belgi bo'lishi kerak."
       }
    }

    override fun back() {
        backLiveData.value=Unit
    }
}