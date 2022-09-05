package uz.gita.football_statistics.repository.impl

import androidx.lifecycle.LiveData
import uz.gita.football_statistics.data.models.SeasonData
import uz.gita.football_statistics.data.remote.ApiClient
import uz.gita.football_statistics.repository.FootballRepository

class FootballRepositoryImpl private constructor() : FootballRepository {

    private val api = ApiClient.footballApi

    override suspend fun getAllLeagues() = api.getAllLeagues()

    override suspend fun getAllLeagueByYear(c: String, d: Int, name: String) =
        api.getAllStandingsByLeagueSeason(c,d)

    companion object {

        private lateinit var instance: FootballRepository

        fun getInstance(): FootballRepository {
            if (!Companion::instance.isInitialized) {
                instance = FootballRepositoryImpl()
            }
            return instance
        }
    }
}