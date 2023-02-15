package uz.it_school_.todoappwithroom.app

import android.app.Application
import uz.it_school_.todoappwithroom.data.repository.impl.IntroRepositoryImpl
import uz.it_school_.todoappwithroom.data.repository.impl.MainRepositoryImpl
import uz.it_school_.todoappwithroom.data.sharedpref.SharedPref
import uz.it_school_.todoappwithroom.data.room.AppDatabase

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPref.init(this)
        IntroRepositoryImpl.init()
        AppDatabase.init(this)
        MainRepositoryImpl.init()

    }
}