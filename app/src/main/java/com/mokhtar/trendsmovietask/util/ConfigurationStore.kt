package com.mokhtar.trendsmovietask.util

import com.mokhtar.androidmoviestask.data.remote.model.configuration.ConfigurationResponse

object ConfigurationStore {

    private lateinit var configurationData: ConfigurationResponse

    fun setConfigurationData(configurationData: ConfigurationResponse){
       this.configurationData=configurationData
    }

    fun getConfigurationData(): ConfigurationResponse {
        return configurationData
    }


}