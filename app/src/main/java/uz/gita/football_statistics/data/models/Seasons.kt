package uz.gita.football_statistics.data.models

data class Seasons(
    val displayName: String,
    val endDate: String,
    val startDate: String,
    val types: List<Type>,
    val year: Int
)