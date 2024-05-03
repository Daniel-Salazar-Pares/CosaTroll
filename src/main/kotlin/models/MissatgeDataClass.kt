package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Ping(val message: String)

var missatgePing:Ping = Ping("")
