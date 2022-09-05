package uz.gita.football_statistics.data.models

data class Stat(
    val abbreviation: String,
    val description: String,
    val displayName: String,
    val displayValue: String,
    val id: String,
    val name: String,
    val shortDisplayName: String,
    val summary: String,
    val type: String,
    val value: Int
)