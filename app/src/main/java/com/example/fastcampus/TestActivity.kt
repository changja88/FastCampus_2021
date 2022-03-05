package com.example.fastcampus

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.FileUtils
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
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.io.File
import androidx.core.app.ActivityCompat.startActivityForResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*

class TestActivity : AppCompatActivity() {

    var fileUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }
}



//class ToDoListRecylcerViewAdapter(
//    val todoList: ArrayList<ToDo>,
//    val inflater: LayoutInflater
//) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    var previouseDate: String = ""
//
//    inner class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val dateTextView: TextView
//
//        init {
//            dateTextView = itemView.findViewById(R.id.date)
//        }
//
//    }
//
//    inner class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val isComplete: ImageView
//        val content: TextView
//
//        init {
//            isComplete = itemView.findViewById(R.id.is_complete)
//            content = itemView.findViewById(R.id.content)
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        if (previouseDate == todoList.get(position).created) {
//            return 0
//        } else {
//            previouseDate = todoList.get(position).created
//            return 1
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        when (viewType) {
//            1 -> return DateViewHolder(inflater.inflate(R.layout.todo_date, parent, false))
//            else -> return ContentViewHolder(inflater.inflate(R.layout.todo_content, parent, false))
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val todo = todoList.get(position)
//        if (holder is DateViewHolder) {
//            (holder as DateViewHolder).dateTextView.text = todo.created
//        } else {
//            (holder as ContentViewHolder).content.text = todo.content
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return todoList.size
//    }
//}