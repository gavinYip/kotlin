package android.kotlin2

import android.kotlin2.i.StringInterface

//用object修饰，相当于Java中的static，用object修饰一个变量，可以实现全局变量的效果
class ArrayListKt { //工具类定义object （其实类似单例）


    //相当于java static 方法
    companion object B :StringInterface{ //申明的伴生对象
        override fun print(): String {
            return ""
        }

        private val list = ArrayList<String>()
        private const val s1 = "1,2-3-4+5-6-7+8-9"

        fun getList(): ArrayList<String> {
            list.add("1android")
            list.add("2android")
            list.add("3android")
            list.add("4android")
            list.add("5android")
            return list
        }

        /*
         * 截取
         */
        /*同一模块下可访问*/ fun split(): ArrayList<String> {
            val list = ArrayList<String>()
            //list += s1.split("-")

            for (s in s1.split("-", ",", "+")) {
                list.add(s)
            }
//        list += s1.split("-",",","+")
            return list
        }

        /*
         * 方法里只有一行代码时，可以简写直接返回
         */
        fun getWhat() = 100

    }

}