package com.example.fragmentsample

import java.lang.Math.abs


//sample data
class ClsListData {
    private var itemCount = 10
    private val dummyList: ArrayList<String> = ArrayList()
    init {
        dummyList.add("sample 001")
        dummyList.add("sample 002")
        dummyList.add("sample 003")
        dummyList.add("sample 004")
        dummyList.add("sample 005")
        dummyList.add("sample 006")
        dummyList.add("sample 007")
        dummyList.add("sample 008")
        dummyList.add("sample 009")
        dummyList.add("sample 010")
    }

    val size: Int
        get() {
            return dummyList.size
        }

    val listData: ArrayList<String>
        get() {
            return dummyList
        }

    //add
    fun putItem() {
        itemCount++
        val itemData: String = String.format("sample %03d", itemCount)
        dummyList.add(itemData)
    }

    //get
    fun getItem(Idx:Int): String {
        return dummyList[Idx]
    }

    //delete
    fun deleteItem(Idx:Int) {
        dummyList.removeAt(Idx)
    }

    //move
    fun moveItem(formIdx:Int, toIdx:Int) {
        when {
            1 == abs(formIdx-toIdx) -> {
                //almost this
                exchangeItem(formIdx, toIdx)
            }
            formIdx < toIdx -> {
                //under from up
                val tmp = dummyList[formIdx]
                val ePosition = toIdx - 1
                for (i:Int in formIdx..ePosition) {
                    exchangeItem(i, i-1)
                }
                dummyList[toIdx] = tmp
            }
        }
    }

    //swap
    private fun exchangeItem(formIdx:Int, toIdx:Int) {
        val tmp: String = dummyList[toIdx]
        dummyList[toIdx] = dummyList[formIdx]
        dummyList[formIdx] = tmp
    }
}