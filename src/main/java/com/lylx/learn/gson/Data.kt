package com.lylx.learn.gson

data class Singer(val id: Long, val name: String, val songs: List<Song>)

data class Song(val id: Long, val name: String)

data class BaseModel<T>(val code:Int, val message:String , val content:T)