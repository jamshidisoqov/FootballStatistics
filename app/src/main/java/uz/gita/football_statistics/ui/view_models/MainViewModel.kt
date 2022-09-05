package uz.gita.football_statistics.ui.view_models

import androidx.lifecycle.LiveData
import uz.gita.football_statistics.data.models.LeagueData

interface MainViewModel {

    val openDetailsLiveData: LiveData<LeagueData>

    val allLeagues: LiveData<List<LeagueData>>

    val messageLiveData: LiveData<String>

    fun getAllLeague()

}