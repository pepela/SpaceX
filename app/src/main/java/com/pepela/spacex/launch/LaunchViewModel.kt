package com.pepela.spacex.launch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pepela.data.launch.interactor.GetLaunchesUseCase
import com.pepela.data.launch.model.Launch


class LaunchViewModel(private val getLaunchesUseCase: GetLaunchesUseCase) : ViewModel() {

    private val launches: LiveData<List<Launch>> by lazy {
        getLaunchesUseCase.execute(null)
    }

    fun getLaunchesLiveData() = launches

}
