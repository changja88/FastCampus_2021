package com.example.fastcampus

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.io.File
import java.io.Serializable


class StudentFromServer(
    val id: Int, val name: String, val age: Int, val intro: String
) {
    constructor(name: String, age: Int, intro: String) : this(0, name, age, intro)
}

class Post(
    val content: String, image: File
)

class YoutubeItem(
    val id: Int, val title: String, val content: String, val video: String, val thumbnail: String
)

class MelonItem(
    val id: Int, val title: String, val song: String, val thumbnail: String
) : Serializable

class User(
    val username: String, val token: String, val id: Int
)

class InstaPost(
    val id: Int, val content: String, val image: String, val owner_profile: OwnerProfile
)

class OwnerProfile(
    val username: String, val image: String?
)

class UserInfo(
    val id: Int,
    val username: String,
    val profile: OwnerProfile
)

class ToDo(
    val id: Int,
    val content: String,
    val is_complete: Boolean,
    val created: String
)

interface RetrofitService {

    @GET("to-do/search/")
    fun seerachToDoList(
        @HeaderMap headers: Map<String, String>,
        @Query("keyword") keyword: String
    ): Call<ArrayList<ToDo>>

    @PUT("to-do/complete/{todoId}")
    fun changeToDoComplte(
        @HeaderMap headers: Map<String, String>,
        @Path("todoId") todoId: Int
    ): Call<Any>


    @GET("to-do/")
    fun getToDoList(
        @HeaderMap headers: Map<String, String>,
    ): Call<ArrayList<ToDo>>

    @POST("to-do/")
    @FormUrlEncoded
    fun makeToDo(
        @HeaderMap headers: Map<String, String>,
        @FieldMap params: HashMap<String, Any>
    ): Call<Any>

    @Multipart
    @PUT("user/profile/{user_id}/")
    fun changeProfile(
        @Path("user_id") userId: Int,
        @HeaderMap headers: Map<String, String>,
        @Part image: MultipartBody.Part,
        @Part("user") user: RequestBody,
    ): Call<Any>

    @GET("user/userInfo/")
    fun getUserInfo(
        @HeaderMap headers: Map<String, String>,
    ): Call<UserInfo>

    @Multipart
    @POST("instagram/post/")
    fun uploadPost(
        @HeaderMap headers: Map<String, String>,
        @Part image: MultipartBody.Part,
        @Part("content") content: RequestBody
    ): Call<Any>


    @POST("instagram/post/like/{post_id}/")
    fun postLike(
        @Path("post_id") post_id: Int
    ): Call<Any>

    @GET("instagram/post/list/all/")
    fun getInstagramPosts(
    ): Call<ArrayList<InstaPost>>

    @POST("user/signup/")
    @FormUrlEncoded
    fun instaJoin(
        @FieldMap params: HashMap<String, Any>
    ): Call<User>


    @POST("user/login/")
    @FormUrlEncoded
    fun instaLogin(
        @FieldMap params: HashMap<String, Any>
    ): Call<User>

    @GET("melon/list/")
    fun getMelonItemList(): Call<ArrayList<MelonItem>>

    @GET("youtube/list/")
    fun getYoutubeItemList(): Call<ArrayList<YoutubeItem>>

    @GET("json/students/")
    fun getStudentList(): Call<ArrayList<StudentFromServer>>

    @POST("json/students/")
    fun createStudent(
        @Body params: HashMap<String, Any>
    ): Call<StudentFromServer>

    @POST("json/students/")
    fun easyCreateStudent(
        @Body studnet: StudentFromServer
    ): Call<StudentFromServer>

    @Multipart
    @Headers("Authorization: token a982a4f7e5bbe790cb97bc1c8e33f5b08fcfc5e7")
    @POST("instagram/post/")
    fun createPost(
        @Part("content") content: String,
        @Part image: MultipartBody.Part
    ): Call<Post>

    @Multipart
    @Headers("Authorization: token cfb42388ec5e95afea475a172d906a1e1ac2da2e")
    @POST("instagram/post/")
    fun createPost1(
        @Part image: MultipartBody.Part,
        @Part("content") content: RequestBody
    ): Call<Post>

}