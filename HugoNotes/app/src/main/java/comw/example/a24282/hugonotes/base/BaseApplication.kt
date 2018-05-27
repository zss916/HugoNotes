package comw.example.a24282.hugonotes.base

import android.app.Application
import android.content.ComponentCallbacks2
import com.bumptech.glide.Glide
import comw.example.a24282.hugonotes.BuildConfig

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            // LeakCanary.install(this)
        }

        //applicationContext相当于java中获取application的Context
        Preference.setContext(applicationContext)
    }

    //根据不同的内存状态，来响应不同的内存策略
    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        // clear Glide cache
        if (level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory()
        }
        // trim memory
        Glide.get(this).trimMemory(level)
    }

    //内存不足时候调用
    override fun onLowMemory() {
        super.onLowMemory()
        // low memory clear Glide cache
        Glide.get(this).clearMemory()
    }
}