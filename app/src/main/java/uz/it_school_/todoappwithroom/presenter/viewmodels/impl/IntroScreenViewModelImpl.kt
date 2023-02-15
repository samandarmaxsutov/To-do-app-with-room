package uz.it_school_.todoappwithroom.presenter.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school_.todoappwithroom.data.repository.impl.IntroRepositoryImpl
import uz.it_school_.todoappwithroom.presenter.viewmodels.IntroScreenViewModel

class IntroScreenViewModelImpl : IntroScreenViewModel,ViewModel() {
    override val openMainScreenLiveData= MutableLiveData<Unit>()

    val repository = IntroRepositoryImpl.getInstance()
    override val nextPageLiveData=MutableLiveData<Int>()
    override val positon= MutableLiveData<Int>()

    override fun nextPage(pos: Int) {

        if (pos==2){
            repository.setIsFirst()
            openMainScreenLiveData.value=Unit
        }else{
            nextPageLiveData.value=(pos+1)
        }
    }
}