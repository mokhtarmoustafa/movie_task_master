package com.mokhtar.androidmoviestask.data.remote.model.movie


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.mokhtar.androidmoviestask.data.remote.model.movie.MoviesResponse.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class MoviesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    companion object {
        const val TABLE_NAME = "tbl_movie"
    }
}