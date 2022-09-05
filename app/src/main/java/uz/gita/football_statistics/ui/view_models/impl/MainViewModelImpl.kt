package uz.gita.football_statistics.ui.view_models.impl

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.gita.football_statistics.data.models.LeagueData
import uz.gita.football_statistics.repository.impl.FootballRepositoryImpl
import uz.gita.football_statistics.ui.view_models.MainViewModel

class MainViewModelImpl : MainViewModel, ViewModel() {

    private val repository = FootballRepositoryImpl.getInstance()

    override val openDetailsLiveData: MutableLiveData<LeagueData> = MutableLiveData()

    override val allLeagues: MutableLiveData<List<LeagueData>> = MutableLiveData()

    override val messageLiveData: MediatorLiveData<String> = MediatorLiveData()

    override fun getAllLeague() {
        viewModelScope.launch {
            val data = repository.getAllLeagues()
            allLeagues.value = data.data ?: emptyList()
        }
    }


}