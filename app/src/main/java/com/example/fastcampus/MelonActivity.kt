package com.example.fastcampus

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable

class MelonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_melon)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(RetrofitService::class.java)

        retrofitService.getMelonItemList().enqueue(object : Callback<ArrayList<MelonItem>> {
            override fun onResponse(
                call: Call<ArrayList<MelonItem>>,
                response: Response<ArrayList<MelonItem>>
            ) {
                if (response.isSuccessful) {
                    val melonItemLIst = response.body()
                    findViewById<RecyclerView>(R.id.melon_list_view).apply {
                        this.adapter = MelonItemRecyclerAdapter(
                            melonItemLIst!!,
                            LayoutInflater.from(this@MelonActivity),
                            Glide.with(this@MelonActivity),
                            this@MelonActivity
                        )
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<MelonItem>>, t: Throwable) {
                Log.d("melonn", "요청 실패")
            }
        })
    }
}

class MelonItemRecyclerAdapter(
    val melonItemList: ArrayList<MelonItem>,
    val inflater: LayoutInflater,
    val glid: RequestManager,
    val context: Context
) : RecyclerView.Adapter<MelonItemRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val thumbnail: ImageView
        val play: ImageView

        init {
            title = itemView.findViewById(R.id.title)
            thumbnail = itemView.findViewById(R.id.thumbnail)
            play = itemView.findViewById(R.id.play)

            play.setOnClickListener {
                val intent = Intent(context, MelonDetailActivity::class.java)
                intent.putExtra("melon_item_list", melonItemList as Serializable)
                intent.putExtra("position", adapterPosition)
                context.startActivity(intent)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.melon_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = melonItemList.get(position).title
        glid.load(melonItemList.get(position).thumbnail).centerCrop().into(holder.thumbnail)
    }

    override fun getItemCount(): Int {
        return melonItemList.size
    }
}