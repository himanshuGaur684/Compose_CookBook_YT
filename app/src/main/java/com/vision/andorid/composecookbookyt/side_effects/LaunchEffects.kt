package com.vision.andorid.composecookbookyt.side_effects

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class FakeViewModel : ViewModel() {

    val state: MutableState<ResultType> = mutableStateOf(ResultType.Idle)

    fun getData() = viewModelScope.launch {
        state.value = ResultType.Loading
        delay(3000)
        state.value = ResultType.Success
    }

}


@Composable
fun LaunchEffectsExample(fakeViewModel: FakeViewModel) {

    val state = fakeViewModel.state.value
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit, block = {
        fakeViewModel.getData()
    })

    when (state) {
        is ResultType.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is ResultType.Success -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Button(onClick = {
                    val job = scope.launch {
                        fakeViewModel.getData()
                    }
                    job.cancel()
                    scope.cancel()
                }) {

                }
            }
        }
        is ResultType.Idle -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Idle")
            }
        }
    }
}