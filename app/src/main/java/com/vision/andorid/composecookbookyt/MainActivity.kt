package com.vision.andorid.composecookbookyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.vision.andorid.composecookbookyt.side_effects.*
import com.vision.andorid.composecookbookyt.ui.theme.ComposeCookBookYTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookBookYTTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
//                    LaunchEffectsExample(fakeViewModel = FakeViewModel())
//                    RememberUpdatedState()
//                    DisposableExample(activity = this,this.onBackPressedDispatcher)
//                    SideEffects()
                }
            }
        }
    }
}







