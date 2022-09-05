package uz.gita.football_statistics.ui.view_models

import androidx.lifecycle.LiveData
import uz.gita.football_statistics.data.models.TableDataWrapperSeason

interface DetailsViewModel {

    val seasonListLiveData: LiveData<TableDataWrapperSeason>

    val dateLiveData: LiveData<Int>

    val messageLiveData: LiveData<String>

    val openChartLiveData: LiveData<Unit>

    fun season(id: String, year: Int, name: String)

    fun setYear(year: Int)

    fun openChart()
}