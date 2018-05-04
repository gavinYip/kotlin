package android.kotlin2

/**
 * 单例
 */
class AnotherSingle private constructor() {

    companion object {
        fun get(): AnotherSingle {
            return Inner.anotherSingle
        }
    }

    private object Inner {
        val anotherSingle = AnotherSingle()

    }
}