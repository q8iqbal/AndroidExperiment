package com.example.androidexperiment.base

interface  BaseView<T>{
    fun attachPresenter(presenter: T)
    fun detachPresenter()
}