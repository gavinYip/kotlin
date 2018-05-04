package android.kotlin2.model

import java.io.Serializable


//通过在最前面加上data关键字，就可以标明这个类是一个数据类。如果一个类被标明为数据类，编译器在编译的时候会自动帮我们覆写常用的toString、hashCode、equals、copy、comopinentX方法。
data /*数据类*/ class Person2(private var name: String = "", private var age: Int = 0) /*主构函数*/ : Serializable