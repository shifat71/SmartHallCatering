package com.shifat.smarthallcatering

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shifat.smarthallcatering.common.snackbar.SnackbarManager
import com.shifat.smarthallcatering.common.snackbar.SnackbarMessage.Companion.toSnackbarMessage
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


open class SmartHallCateringViewModel() : ViewModel() {
    fun launchCatching(snackbar: Boolean = true, block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                if (snackbar) {
                    SnackbarManager.showMessage(throwable.toSnackbarMessage())
                }

            },
            block = block
        )
}
