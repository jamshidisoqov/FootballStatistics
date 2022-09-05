package uz.gita.football_statistics.data.models

data class ResponseData<T>(
    var status: Boolean,
    val data: T
)
