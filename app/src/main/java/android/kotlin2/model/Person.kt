package android.kotlin2.model

import android.kotlin2.i.StringInterface
import java.io.Serializable


//通过在最前面加上data关键字，就可以标明这个类是一个数据类。如果一个类被标明为数据类，编译器在编译的时候会自动帮我们覆写常用的toString、hashCode、equals、copy、comopinentX方法。
open /*数据类*/ class Person(private var name: String = "", private var age: Int = 0) /*主构函数*/ : Serializable, StringInterface {

//    var name: String
//    var age: Int
//    init { //初始化操作
//        name = ""
//        age = 0
//    }
//    constructor() //次构函数
//    constructor(name: String,/*var*//*次构函数不支持快捷转换*/ age: Int) {
//        this.name = name
//        this.age = age
//    }

    override fun print(): String {
        return "Person(name='$name', age='$age')"
    }

    open fun eat(){
        println("father ear")
    }

    /*
     * 扩展方法
     */
    fun String.getLastChar(): String {
        return this.substring(this.length - 1, this.length)
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}