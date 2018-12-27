package com.lylx.learn.gson

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

fun main(args: Array<String>) {
    val singerJson = File("singer.json").readText()
    val singer = Gson().fromJson(singerJson, Singer::class.java)
    println(singer)

    val singerResult: Singer = Gson().fromJson(singerJson)
    println(singerResult)

    //解析出来的content没有指定类型：真正运行的时候类型被擦除，拿到的class是BaseModel
    val resultSingerJson = File("result_singer.json").readText()
    val resultSinger: BaseModel<Singer> = Gson().fromJson(resultSingerJson)
    println(resultSinger)
//    println(resultSinger.content.name)

    //使用泛型注意
    val objectType = object : TypeToken<BaseModel<Singer>>() {}.type
    val data: BaseModel<Singer>  = Gson().fromJson(resultSingerJson,objectType)
    println(data)
    println(data.content.name)


    val result : BaseModel<Singer> = ApiFactory.api.getSingerFromJson(resultSingerJson)
    println(result)
    println(result.content.name)

    //针对不存在字段，返回null
    val resultSingerLossJson = File("result_singer_field_loss.json").readText()
    val resultSingerLoss : BaseModel<Singer> = ApiFactory.api.getSingerFromJson(resultSingerLossJson)
    println(resultSingerLoss)

    val resultObjectType = object : TypeToken<BaseModel<Singer>>() {}.type
    val resultLoss : BaseModel<Singer> = Gson().fromJson(resultSingerLossJson,resultObjectType)
    println(resultLoss)
}

//reified 不是万能的，必须在调用他的时候传入一个确定的类型
//fun <T:Any> getResult(json:String):T{
//    return Gson().fromJson(json)
//}
