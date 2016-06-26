package controllers

import play.api.mvc._
import javax.inject._
import play.api.libs.json.Json
import play.api._
import play.api.routing._

case class AvailabilityResponse(
  result: String,
  ticketQuanity: Option[Long]
)

object AvailabilityResponse {
  implicit val responseFormat = Json.format[AvailabilityResponse]
}

class Tickets @Inject() extends Controller {
  
  def index = Action {
    Ok(views.html.index())
  }
 
  def jsRoutes = Action { implicit request =>
    Ok(
        JavaScriptReverseRouter("jsRoutes")(
            routes.javascript.Tickets.ticketsAvailable
        )
    ).as("text/javascript")
  }
  
  def ticketsAvailable = Action { request =>
    val availableTickets = 1000
    val result = AvailabilityResponse("ok", Option(availableTickets))
    Ok(Json.toJson(result))
  }
}