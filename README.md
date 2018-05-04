about kotlin

1.null机制中的一个操作符 ?: 这个操作符很强大，如果某个对象为null,可以设置我们想要的结果 Log.d(tag ?: "MainActivity", tv.text as String)

2.通过在最前面加上data关键字，就可以标明这个类是一个数据类。如果一个类被标明为数据类，编译器在编译的时候会自动帮我们覆写常用的toString、hashCode、equals、copy、comopinentX方法
open class Person(private var name: String = "", private var age: Int = 0) : Serializable

3.数据类不能有以下修饰符：abstract，inner,open,sealed

4.Kotlin中的继承关系，通过冒号去表示。
  父类需要通过open关键字表示，才可以被继承
  父类方法需要通过open关键字表示，子类才可以重写方法
  父类属性需要通过open关键字表示，子类才可以重写属性
  
5.抽象类可以包含非抽象方法，抽象类不能被实例化，抽象类可以包含非抽象属性和抽象属性，抽象属性不能赋值，即不可实例(跟java一样)

6.实现接口跟继承一样用冒号，接口的方法默认子类必须实现，所有不用带open关键字。也或者子类定义为抽象类，可以不实现接口中的方法

7.Kotlin的拓展函数则不存在子类优先的原则。Kotlin的拓展函数是静态解析的，完全由当前变量的类型决定。与Java中的子类方法优先不同
  类本身的成员函数和拓展函数同名会怎样呢？Kotlin的拓展函数针对成员函数和拓展函数同名问题，遵循成员函数优先的原则。
  
8.在Kotlin 也直接支持委托模式，更加优雅，简洁。Kotlin 通过关键字 by 实现委托。
![avatar](http://p7u2ilcwj.bkt.clouddn.com/img1.png)

9.通过companion object关键字申明的伴生对象，方法或者属性调用的时候就是【类.方法（）】、【类.属性】, 类似java里面的静态方法的调用
   class A  {
   companion object b {
   
     }
   }
   这里的B就是A的伴身对象，只有在A创建的时候，对象B的实例才会创建。伴身对象可以有自己的方法和属性，甚至可以实现接口，继承类。
   伴身对象内的方法访问可以有【外部类.内部类.方法()】的形式或者【外部类.方法()】。伴身对象内的属性访问可以有【外部类.内部类.属性】的形式或者【外部类.属性】。
   可以看出外部类的访问权限可以跨过内部类直接访问内部类的属性以及方法
 
10.通过List接口构造方法和listOf方法创建的集合是不可写的，通过arrayListOf方法和mutableListOf方法创建的集合是可写的。
   通过Map接口构造方法和mapOf方法创建的集合是不可写的，mutableMapOf方法创建的集合是可写的。
   toMutableXXX()把不可写转为可写操作
   
11.java的switch分支语句在kotlin用when




