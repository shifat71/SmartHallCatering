package com.shifat.smarthallcatering.data.remote

import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.user.Customer
import com.shifat.smarthallcatering.model.user.Provider

fun findProviderById( id: Int ) : Provider {
    return DataSource.provider
}

fun findCustomerById(id: Int) : Customer {
 return DataSource.customer
}
