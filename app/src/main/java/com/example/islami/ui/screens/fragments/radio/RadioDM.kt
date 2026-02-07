package com.example.islami.ui.screens.fragments.radio

import java.io.Serializable

data class RadioDM(var sheickhName : String, var bg_status : Int, var audio_status : Int, var play_status : Int,var isPlaying: Boolean = false  ): Serializable
