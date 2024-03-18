package com.shifat.smarthallcatering.ui.screens.customer.CustomerHomeScreen

import com.shifat.smarthallcatering.SmartHallCateringViewModel
import com.shifat.smarthallcatering.model.service.StorageService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class CustomerHomeScreenViewModel @Inject constructor(
    private val storageService: StorageService
) : SmartHallCateringViewModel() {

    val providers = storageService.providers


}