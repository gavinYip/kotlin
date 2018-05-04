package android.kotlin2.model

import kotlin.properties.Delegates


open class Father : Person() {

    var run: Run = Run()
    open var hasMoney = "money"

    var go by Delegates.notNull<String>()


    class Run {
        fun goEvery() {
            println("father run!")
        }

    }

    open fun sleep(): String {
        return "sleep"
    }
}