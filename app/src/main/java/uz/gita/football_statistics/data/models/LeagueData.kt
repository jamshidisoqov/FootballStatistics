package uz.gita.football_statistics.data.models

data class LeagueData(
    val abbr: String,
    val id: String,
    val logos: Logos,
    val name: String,
    val slug: String
)