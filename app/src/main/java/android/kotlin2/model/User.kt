package android.kotlin2.model


class User(map: MutableMap<String, Any>?) {
    var name: String by map
    var age: Int by map



    override fun toString(): String {
        return "User:$name\n$age"
    }



}