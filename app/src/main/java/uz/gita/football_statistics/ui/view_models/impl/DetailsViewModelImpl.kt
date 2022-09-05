package uz.gita.football_statistics.ui.view_models.impl

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.gita.football_statistics.data.models.TableDataWrapperSeason
import uz.gita.football_statistics.data.models.table_view.ColumnHeader
import uz.gita.football_statistics.data.models.table_view.ImageCell
import uz.gita.football_statistics.data.models.table_view.RowHeader
import uz.gita.football_statistics.data.models.table_view.TextCell
import uz.gita.football_statistics.repository.impl.FootballRepositoryImpl
import uz.gita.football_statistics.ui.view_models.DetailsViewModel

class DetailsViewModelImpl : DetailsViewModel, ViewModel() {

    private val repository = FootballRepositoryImpl.getInstance()

    override val seasonListLiveData: MutableLiveData<TableDataWrapperSeason> = MutableLiveData()

    override val dateLiveData: MutableLiveData<Int> = MutableLiveData(2022)

    override val messageLiveData: MediatorLiveData<String> = MediatorLiveData()

    override val openChartLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun season(id: String, year: Int, name: String) {
        viewModelScope.launch {
            val data = repository.getAllLeagueByYear(id, year, name).data
            val rowHeader = (1..data.standings.size).map {
                RowHeader(it.toString())
            }.toList()
            val columnHeader =
                listOf(
                    "legue name",
                    "logo",
                    "year",
                    "location",
                    "name",
                    "abbreviation",
                    "displayValue",
                    "description"
                ).map { ColumnHeader(it) }
            var counter = 0
            val cellList = data.standings.map {

                listOf(
                    TextCell(data.name),
                    ImageCell(it.team.logos[0].href),
                    TextCell(data.season.toString()),
                    TextCell(it.team.location),
                    TextCell(it.team.name),
                    TextCell(it.team.abbreviation),
                    TextCell(
                        it.stats[if (counter < it.stats.size) {
                            counter
                        } else {
                            counter
                        }].displayValue
                    ),
                    TextCell(
                        it.stats[if (counter < it.stats.size - 1) {
                            counter++
                        } else {
                            counter
                        }].description
                    )
                )
            }
            val tableDataWrapper = TableDataWrapperSeason(rowHeader, columnHeader, cellList)
            seasonListLiveData.value = tableDataWrapper

        }
    }

    override fun setYear(year: Int) {
        dateLiveData.value = year
    }

    override fun openChart() {
        openChartLiveData.value = Unit
    }

}