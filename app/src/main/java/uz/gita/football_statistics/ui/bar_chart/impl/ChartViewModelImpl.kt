package uz.gita.football_statistics.ui.bar_chart.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.gita.football_statistics.data.models.TeamsBySeason
import uz.gita.football_statistics.repository.impl.FootballRepositoryImpl
import uz.gita.football_statistics.ui.bar_chart.ChartViewModel

class ChartViewModelImpl : ChartViewModel, ViewModel() {

    private val repository = FootballRepositoryImpl.getInstance()

    override val allSeasonsByLeague: MutableLiveData<TeamsBySeason> = MutableLiveData()

    override fun getAllTeams(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllLeagueByYear(id, 2021, "Premier")
            allSeasonsByLeague.postValue(response.data!!)
        }

    }
}