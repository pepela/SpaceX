package com.pepela.data.launch

import androidx.lifecycle.LiveData
import com.pepela.data.launch.model.Launch

interface LaunchRepository {
    fun getLaunches(): LiveData<List<Launch>>
}
