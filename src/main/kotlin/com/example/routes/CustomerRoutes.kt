package com.example.routes

import com.example.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting() {
    route("/missatgePing") {
        get {
            if (missatgePing.message != "") {
                call.respond(missatgePing)
            } else {
                call.respondText("No s'han trobat clients", status = HttpStatusCode.OK)
            }
        }

        post {
            val msg = call.receive<Ping>()
            missatgePing = Ping("Resposta pong ${msg.message}")
        }
    }
}