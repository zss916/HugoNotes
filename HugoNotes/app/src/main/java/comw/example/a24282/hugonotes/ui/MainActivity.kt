package comw.example.a24282.hugonotes.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import comw.example.a24282.hugonotes.R
import comw.example.a24282.hugonotes.base.BaseActivity

class MainActivity : BaseActivity() {


    override fun setLayOut(): Int  = R.layout.activity_main

    //继承父类的方法
    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar.titleBar(R.id.toolbar).init()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }



}
