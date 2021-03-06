package com.abhi.task3.models

interface Section {
    fun type(): Int
    fun sectionId(): Int

    companion object {
        const val HEADER = 0
        const val ITEM = 1
    }
}