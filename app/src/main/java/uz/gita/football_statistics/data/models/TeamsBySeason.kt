package uz.gita.football_statistics.data.models

// Created by Jamshid Isoqov an 8/29/2022
data class TeamsBySeason(
    val name: String,
    val abbreviation: String,
    val seasonDisplay: String,
    val season: Int,
    val standings: List<TeamData>
)
