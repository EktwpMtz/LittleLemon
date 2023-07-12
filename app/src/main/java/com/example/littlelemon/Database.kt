package com.example.littlelemon

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

@Dao
interface DishDao {
    @Query("SELECT * FROM dish")
    fun getAll(): LiveData<List<Dish>>

    @Insert
    fun insertAll(vararg dishes: Dish)

    @Query("SELECT (SELECT COUNT(*) FROM Dish) == 0")
    fun isEmpty(): Boolean
}

@Database(entities = [Dish::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dishDao(): DishDao
}

class DishRepository(context: Context) {
    private val database = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "dish.db"
    ).build()

    fun getAllDishes() = database.dishDao().getAll()

    fun setDishes(vararg dishes: Dish) = database.dishDao().insertAll(*dishes)

    fun isEmpty() = database.dishDao().isEmpty()
}

@Entity
data class Dish(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String,
)