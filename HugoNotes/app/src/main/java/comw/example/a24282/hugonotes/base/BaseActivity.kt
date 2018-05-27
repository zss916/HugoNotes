package comw.example.a24282.hugonotes.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.gyf.barlibrary.ImmersionBar

abstract class BaseActivity : AppCompatActivity() {

    //as上如何用快捷键转化的，不知道？
    protected lateinit var immersionBar: ImmersionBar

    //lazy延迟加载
    private val imm: InputMethodManager by lazy {
        //as是转化成类型
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayOut())
        //沉浸式导航栏管理，开源代码
        initImmersionBar()
    }

    protected abstract fun setLayOut(): Int

    open protected fun initImmersionBar() {
        //在BaseActivity初始化
        immersionBar = ImmersionBar.with(this)
        immersionBar.init()
    }

    override fun onDestroy() {
        super.onDestroy()
        immersionBar.destroy()
        //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }

    override fun finish() {
        super.finish()
        hideSoftKeyBoard()
    }

    private fun hideSoftKeyBoard() {
        //let默认对象是it参数，返回值是函数的最后一行
        currentFocus.let {
            imm.hideSoftInputFromWindow(it.windowToken,2)
        }
    }
}