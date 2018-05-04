package android.kotlin2

import android.annotation.SuppressLint
import android.content.Intent
import android.kotlin2.model.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import java.io.BufferedReader
import java.io.StringReader

class MainActivity : AppCompatActivity(), Button.SetOnClickListener {

    companion object {
        private val tag = null
    }

    private var isPress = false
    private lateinit var tv: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv)
        val btn = findViewById<TextView>(R.id.btn)
        tv.text = "Hello yip"

        /*  (?:)这个操作符很强大，如果某个对象为null,可以设置我们想要的结果*/
        Log.d(tag ?: "MainActivity", tv.text as String)

        for (item in ArrayListKt.getList()) {
            Log.i(tag ?: "Main", item)
        }

        for (item in ArrayListKt.split()) {
            Log.i(tag ?: "MainA", item)
        }

        val what = ArrayListKt.getWhat()

        //val get = AnotherSingle.get()

        val son = Son()

        Log.d(tag ?: "no-null", son.sleep())

        Log.d(tag ?: "MainB", what.toString())
        btn.setOnClickListener {
            if (!isPress) {
                isPress = true
                tv.text = "Press is true"
                startActivity()
            } else {
                isPress = false
                tv.text = "Press is false"
            }

        }
//        readNumber()

        val person = Person("222", 6)
        val person2 = Person()
        val person3 = Person2("mao", 22)

        val person4 = object : Person("333", 12) {

            override fun eat() {
                //super.eat()
                println("son eat")
            }

        }
        person4.eat()

        Log.d("main", person.toString() + "\n" + person2.print() + "\n" + person3)

        val run = Father().run.goEvery()
        Log.d("main", run.toString())

        val map: MutableMap<String, Any> = mutableMapOf("name" to "yip", "age" to 20)
        val user = User(map)
        println(user.toString())


        val button = Button()
        button.setOnClickListener(this)

        Son().show()

        Son().showRange()

        Son().list()

        Son().listEach()

// button.setOnClickListener(object : Button.SetOnClickListener {
//     override fun onClick() {
//     }
// })
    }

    private fun startActivity() {
        val b = Intent(this, GuideActivity::class.java)
        startActivityForResult(b, 2)
    }


    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2) {
            tv.text = "Press is false"
        }
    }


    private fun readNumber(reader: Any) {
        if (reader !is BufferedReader) {
            //do nothing
            val bufferedReader = reader as? BufferedReader //is、!is 智能转换 , as、as? 强制转换
            Log.d("jjj", bufferedReader?.readLine())
        } else {
            val line: Int = try {
                Integer.parseInt(reader.readLine()/*不需要强转*/)
            } catch (e: Exception) {
                0
            }
            /*return try {
                Integer.parseInt(reader.readLine())
            } catch (e: Exception) {
                0
            }*/
            println(line)
        }
    }

    private fun readNumber() {
        val reader = BufferedReader(StringReader("hello"))
        readNumber(reader = reader) //参数命名
    }

    override fun onClick() {
        //接口回调
    }
}

