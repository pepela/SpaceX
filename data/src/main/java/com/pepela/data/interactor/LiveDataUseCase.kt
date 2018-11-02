package com.pepela.data.interactor

import androidx.lifecycle.LiveData

abstract class LiveDataUseCase<T, in Params> {
    abstract fun buildUseCase(params: Params?): LiveData<T>

    open fun execute(params: Params?): LiveData<T> = buildUseCase(params)
}
