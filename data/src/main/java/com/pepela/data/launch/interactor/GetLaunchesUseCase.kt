package com.pepela.data.launch.interactor

import androidx.lifecycle.LiveData
import com.pepela.data.interactor.LiveDataUseCase
import com.pepela.data.launch.LaunchRepository
import com.pepela.data.launch.model.Launch


class GetLaunchesUseCase(private val launchRepository: LaunchRepository)
    : LiveDataUseCase<List<Launch>, Void>() {
    
    override fun buildUseCase(params: Void?): LiveData<List<Launch>> =
            launchRepository.getLaunches()

}
