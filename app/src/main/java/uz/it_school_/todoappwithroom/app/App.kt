package uz.it_school_.todoappwithroom.app

import android.app.Application
import uz.it_school_.todoappwithroom.data.room.AppDatabase

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
    }
}