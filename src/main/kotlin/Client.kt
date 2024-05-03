import com.example.models.Ping
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

suspend fun main() {
    val client = HttpClient(CIO)

    var sortir = false

    while (!sortir) {
        println("Escriu \"-1\" per sortir o escriu un missatge per fer ping:")

        val input = readlnOrNull() ?: ""

        if (input.trim() != "-1") {
            val responsePost: HttpResponse = client.post("http://127.0.0.1:9292/missatgePing") {
                url("http://127.0.0.1:9292/missatgePing")
                contentType(ContentType.Application.Json)
                setBody(Json.encodeToString(Ping(input)))
            }
            println("AFTER POST STATUS: ${responsePost.status}")
            val responseGet = client.get("http://127.0.0.1:9292/missatgePing")
            println("AFTER GET STATUS: ${responseGet.status}")
            val responseBody = responseGet.bodyAsText()
            println(responseBody)

            val ping = Json.decodeFromString<Ping>(responseBody)
            println(ping)
            println("Següent missatge: ")
        } else {
            sortir = true
        }
    }



    client.close()
}