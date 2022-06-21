package com.mokhtar.androidmoviestask.data.remote.model.configuration


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.mokhtar.androidmoviestask.data.remote.model.configuration.ConfigurationResponse.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ConfigurationResponse(
    @SerializedName("change_keys")
    val changeKeys: List<String>,
    @SerializedName("images")
    val images: Images
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    companion object {
        const val TABLE_NAME = "tbl_configuration"
    }
}