package android.kotlin2.model

import android.util.Log

class Son : Father() {

    override var hasMoney = "money"

    var hasToy: String = ""

    fun cry() {}

    var noMoney: Int = 0


    fun show() {
        val innerSon = object {
            val name: String = "java"
            val age: Int = 20
        }
        println(innerSon.name + "  " + innerSon.age)
    }


    override fun sleep(): String {
        go = "nihao"

        return go
    }


    //区间
    private val range = 'a'..'d'

    fun showRange() {
        range.forEach {
            Log.d("yip", it.toString())
        }

        range.forEachIndexed { index, char ->
            Log.d("yip", "$index->$char")
        }


    }

    //数组
    private var array = arrayOf("a", "b", "c")

    fun list() {

        array.forEachIndexed { index, s ->

            when (index) {
                0 -> Log.d("yip2_0", s)
                1 -> Log.d("yip2_1", s)
                2 -> Log.d("yip2_2", s)
                3 -> Log.d("yip2_3", s)
                12 -> Log.d("yip2_4", s)
            }
        }
        val orNull = array.getOrNull(10)
        println("$orNull")
        Log.d("yip_not_null", "$orNull")
    }

    //集合
    private var list = listOf("1", '2', 2, Father(), 11.2)

    fun listEach() {
        list.forEachIndexed { index, s ->

            println("$index,$s")

        }
    }

}