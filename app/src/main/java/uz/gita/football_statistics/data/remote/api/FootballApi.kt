package uz.gita.football_statistics.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.gita.football_statistics.data.models.LeagueData
import uz.gita.football_statistics.data.models.ResponseData
import uz.gita.football_statistics.data.models.SeasonData
import uz.gita.football_statistics.data.models.TeamsBySeason

// Created by Jamshid Isoqov an 8/29/2022
interface FootballApi {

    @GET("/leagues")
    suspend fun getAllLeagues(): ResponseData<List<LeagueData>>

    @GET("/leagues/{id}/seasons")
    suspend fun getAllSeasonsByLeague(@Path("id") id: Int): ResponseData<SeasonData>

    @GET("leagues/{id}/standings")
    suspend fun getAllStandingsByLeagueSeason(
        @Path("id") id: String,
        @Query("season") year: Int,
        @Query("sort") sort: String = "asc"
    ): ResponseData<TeamsBySeason>

}