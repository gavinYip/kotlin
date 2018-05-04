package android.kotlin2.model

class Button {
    /*
     接口回调
     */
    fun setOnClickListener(listener: SetOnClickListener) {
        listener.onClick()
    }

    interface SetOnClickListener {
        fun onClick()
    }
}