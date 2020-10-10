package com.example.androidexperiment.model

import java.util.*

data class Task(
    var title: String,
    var description: String,
    var createdAt: String){

    fun clear(){
        title = ""
        description = ""
        createdAt = ""
    }
}