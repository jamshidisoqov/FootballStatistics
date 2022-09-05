package uz.gita.football_statistics.data.models

data class Type(
    val abbreviation: String,
    val endDate: String,
    val hasStandings: Boolean,
    val id: String,
    val name: String,
    val startDate: String
)