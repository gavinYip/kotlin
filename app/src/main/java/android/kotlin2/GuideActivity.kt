package android.kotlin2

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import java.util.*

class GuideActivity : Activity() {

    private lateinit var mAdvPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        //初始化数据
        mAdvPager = findViewById(R.id.guide_activity_adv_pager)
        dataInit()
    }


    private fun dataInit() {
        val mImageUrl = ArrayList<Int>()
        mImageUrl.add(R.mipmap.guide1)
        mImageUrl.add(R.mipmap.guide2)
        mImageUrl.add(R.mipmap.guide3)
        mImageUrl.add(R.mipmap.guide4)
        mImageUrl.add(R.mipmap.guide5)
        mImageUrl.add(R.mipmap.guide6)
        mImageUrl.add(R.mipmap.guide7)
        val adapter = ImageCycleAdapter(this, mImageUrl)
        mAdvPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        mAdvPager.adapter = adapter
    }

    private inner class ImageCycleAdapter internal constructor(private val mContext: Context, adList: ArrayList<Int>) : PagerAdapter() {
        /**
         * 图片视图缓存列表
         */
        private val mImageViewCacheList: ArrayList<ImageView>

        /**
         * 图片资源列表
         */
        private var mAdList = ArrayList<Int>()

        init {
            mAdList = adList
            mImageViewCacheList = ArrayList()
        }

        override fun getCount(): Int {
            return mAdList.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val imageUrl = mAdList[position]
            val imageView: ImageView
            if (mImageViewCacheList.isEmpty()) {
                imageView = ImageView(mContext)
                imageView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                imageView.scaleType = ImageView.ScaleType.FIT_XY

            } else {
                imageView = mImageViewCacheList.removeAt(0)
            }
            imageView.tag = imageUrl
            container.addView(imageView)
            imageView.setImageResource(Integer.parseInt(imageUrl.toString()))
            return imageView
        }

        override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
            val view = any as ImageView
            container.removeView(view)
            mImageViewCacheList.add(view)
        }
    }

    override fun onBackPressed() {
        setResult(2)
        finish()
    }
}