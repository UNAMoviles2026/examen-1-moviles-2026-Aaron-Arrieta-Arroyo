package com.moviles.examenmoviles.viewmodel

import androidx.lifecycle.ViewModel
import com.moviles.examenmoviles.data.mock.MockData
import com.moviles.examenmoviles.data.model.CoworkingSpace
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel responsible for providing coworking space data to the UI
 * layer. It keeps business/data logic out of the composables, as
 * required by the MVVM pattern.
 */
class CoworkingViewModel : ViewModel() {

    private val _spaces: MutableStateFlow<List<CoworkingSpace>> =
        MutableStateFlow(MockData.coworkingSpaces)

    /** Immutable stream of all coworking spaces to be observed by the UI. */
    val spaces: StateFlow<List<CoworkingSpace>> = _spaces.asStateFlow()

    /**
     * Returns the coworking space that matches [id] or `null` when it
     * cannot be found. The lookup is performed against the current
     * snapshot of the state flow.
     */
    fun getSpaceById(id: Int): CoworkingSpace? {
        return _spaces.value.firstOrNull { it.id == id }
    }
}
