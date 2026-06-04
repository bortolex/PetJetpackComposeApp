package com.example.petjetpackcomposeapp.kotlin_features

class ScopeFunctions {
    fun letAndApply(){
        val str = "something"

        str.apply {
            this.plus("another").isEmpty()
        }

        str.let {
            println(it)
            anotherFunction(it)
        }.let {

        }

        str.also { strIt ->
            strIt.isEmpty()
        }.also {  }

        str.also {  }


    }

    fun anotherFunction(it: String){}
}