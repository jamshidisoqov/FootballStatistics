package uz.gita.football_statistics.data.models

// Created by Jamshid Isoqov an 8/29/2022
data class SeasonData(
    val name: String,
    val desc: String,
    val abbreviation: String,
    val list: List<Seasons>
)
