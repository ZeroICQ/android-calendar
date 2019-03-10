package com.github.zeroicq.android_calendar.ui.views

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import com.github.zeroicq.android_calendar.R
import com.github.zeroicq.android_calendar.databinding.ActivityMainBinding
import com.github.zeroicq.android_calendar.ui.adapters.MonthDaysAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        val days =  ArrayList<String>()
        for (i in 1..31) {
            days.add(i.toString())
        }
        val viewManager = object : GridLayoutManager(this@MainActivity, 7) {
            override fun canScrollVertically() = false

            override fun canScrollHorizontally() = false

            private fun spanLayoutSize(layoutParams: RecyclerView.LayoutParams): RecyclerView.LayoutParams {
                if (orientation == HORIZONTAL) {
                    layoutParams.width = Math.round(getHorizontalSpace()/Math.ceil((itemCount / spanCount).toDouble())).toInt()
                }
                else if(orientation == VERTICAL) {
                    layoutParams.height = Math.round(getVerticalSpace()/Math.ceil((itemCount / spanCount).toDouble())).toInt()
                }
                return layoutParams
            }

            private fun getHorizontalSpace() = width - paddingRight - paddingLeft
            private fun getVerticalSpace() = height - paddingBottom - paddingTop

            override fun generateLayoutParams(c: Context?, attrs: AttributeSet?): RecyclerView.LayoutParams {
                return spanLayoutSize(super.generateLayoutParams(c, attrs))
            }

            override fun generateLayoutParams(lp: ViewGroup.LayoutParams?): RecyclerView.LayoutParams {
                return spanLayoutSize(super.generateLayoutParams(lp))
            }
        }

        binding.monthRecyclerView.apply {
            adapter = MonthDaysAdapter()
            layoutManager = viewManager
            setHasFixedSize(true)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
