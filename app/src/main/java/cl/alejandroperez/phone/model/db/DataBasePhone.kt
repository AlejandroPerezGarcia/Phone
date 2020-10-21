package cl.alejandroperez.phone.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [EntityProduct::class,EntityDetail::class] , version = 1)
abstract class DataBasePhone : RoomDatabase() {

    abstract fun getDaoPhone(): DaoPhone

    companion object {

        @Volatile
        private var INSTANCE: DataBasePhone? = null

        fun getDatabase(context: Context): DataBasePhone {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBasePhone::class.java,
                    "Phone_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}