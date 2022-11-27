package com.vision.andorid.composecookbookyt.side_effects

sealed class ResultType{
    object Success:ResultType()
    object Loading:ResultType()
    object Idle:ResultType()
}
