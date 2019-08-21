package com.example.fragmentsample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    private  val mSampleData = ClsListData()
    var mContext: Context? = null
    companion object {
        fun createInstance(mc: Context): MainFragment {
            //instance? function that called when creating instance in MainActivity
            val tmpDetailFragment = MainFragment()
            tmpDetailFragment.mContext = mc
            return tmpDetailFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val r = inflater.inflate(R.layout.fragment_main, container, false)
        return r
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRedisplay()
        view.findViewById<Button>(R.id.btnAdd1).setOnClickListener {
            mSampleData.putItem()
            listRedisplay()
        }
    }

    private fun listRedisplay() {
        if(null != mContext) {
            val listAdapter = ArrayAdapter<String>(mContext!!, android.R.layout.simple_expandable_list_item_1)
            val data = mSampleData.listData
            for (i: Int in 1..data.size) {
                listAdapter.add(data[i - 1])
            }
            listView1.adapter = listAdapter
        }
    }


}