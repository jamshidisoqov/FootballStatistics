package uz.gita.football_statistics.utils.extesions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// Created by Jamshid Isoqov an 8/29/2022


fun ViewGroup.inflate(resId: Int):View = LayoutInflater.from(this.context).inflate(resId, this, false)
