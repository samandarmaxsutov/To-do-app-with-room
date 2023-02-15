package uz.it_school_.todoappwithroom.data.repository.impl

import uz.it_school_.todoappwithroom.data.repository.IntroRepository
import uz.it_school_.todoappwithroom.data.sharedpref.SharedPref

class IntroRepositoryImpl private constructor(): IntroRepository {
    private val  sharedPref=SharedPref.getInstance()

    companion object {
        private var introRepositoryImpl:IntroRepository?=null
        fun init(){
            if (introRepositoryImpl==null){
                introRepositoryImpl= IntroRepositoryImpl()
            }
        }
        fun getInstance()= introRepositoryImpl!!
    }

    override fun getIsFirst(): Boolean {
        return sharedPref.getIsFirst()
    }

    override fun setIsFirst() {
        sharedPref.setIsFirst()
    }
}