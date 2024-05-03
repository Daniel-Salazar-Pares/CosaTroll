package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import com.example.routes.*

fun Application.configureRouting() {
    routing {
        customerRouting()
    }
}
