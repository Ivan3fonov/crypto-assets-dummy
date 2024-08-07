package com.example.informationsystem.feature.home.domain.usecase

import com.example.informationsystem.common.result.mapState
import com.example.informationsystem.feature.home.domain.repository.AssetsRepository
import javax.inject.Inject

class GetCryptoAssetsUseCase
@Inject constructor(private val assetsRepository: AssetsRepository) {

    operator fun invoke() = assetsRepository.getAssets().mapState { assets ->
        assets.take(20)
    }
}