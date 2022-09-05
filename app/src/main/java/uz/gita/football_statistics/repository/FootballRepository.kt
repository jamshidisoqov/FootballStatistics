package uz.gita.football_statistics.repository

import androidx.lifecycle.LiveData
import uz.gita.football_statistics.data.models.LeagueData
import uz.gita.football_statistics.data.models.ResponseData
import uz.gita.football_statistics.data.models.SeasonData
import uz.gita.football_statistics.data.models.TeamsBySeason

// Created by Jamshid Isoqov an 8/28/2022
interface FootballRepository {

    suspend fun getAllLeagues():ResponseData<List<LeagueData>>

    suspend fun getAllLeagueByYear(c: String, d: Int,name:String): ResponseData<TeamsBySeason>

}