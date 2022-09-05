package uz.gita.football_statistics.ui.bar_chart

import androidx.lifecycle.LiveData
import uz.gita.football_statistics.data.models.TeamsBySeason

interface ChartViewModel {

    val allSeasonsByLeague: LiveData<TeamsBySeason>

    fun getAllTeams(id: String)
}