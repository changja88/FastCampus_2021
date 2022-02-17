package com.example.fastcampus

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import org.w3c.dom.Text
import androidx.room.RoomDatabase

import androidx.room.Database


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query(
        "SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Insert(onConflict = REPLACE)
    fun insert(user: User)
//
//    @Query("DELETE FROM Contact WHERE id = :contact_id")
//        fun delete(user: User)
}

@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

//@Database(entities = [User::class], version = 1)
//abstract class UserDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao
//
//    companion object {
//        private var INSTANCE: UserDatabase? = null
//        fun getInstance(context: Context): UserDatabase? {
//            if (INSTANCE == null) {
//                synchronized(UserDatabase::class) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        UserDatabase::class.java, "user_table.db"
//                    ).fallbackToDestructiveMigration().build()
//                }
//            }
//            return INSTANCE
//        }
//    }
//
//    fun destryInstance() {
//        INSTANCE = null
//    }
//}

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

//        val userDatabase: UserDatabase =
//            Room.databaseBuilder(this, UserDatabase::class.java, "user_table").build()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
        // insert
        val user: User = User(1, "홍길동", "주소")
        db.userDao().insert(user)

        // Read
        val a = db.userDao().getAll()
        Log.d("testt", "" + a)

    }
}
//@Entity(tableName = "employments")
//data class Employment(
//    @PrimaryKey(autoGenerate = true) val id: Long,
//    @ColumnInfo(name = "code") val code: String,
//    @ColumnInfo(name = "title") val name: String
//){
//    constructor(code: String, name: String) : this(0, code, name)
//}