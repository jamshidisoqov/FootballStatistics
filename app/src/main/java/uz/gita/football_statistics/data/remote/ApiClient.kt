package uz.gita.football_statistics.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.football_statistics.data.remote.api.FootballApi

// Created by Jamshid Isoqov an 8/29/2022
object ApiClient {

    private const val baseUrl = "https://api-football-standings.azharimm.site"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val footballApi: FootballApi = retrofit.create(FootballApi::class.java)

}