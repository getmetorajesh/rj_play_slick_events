package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json.Json
import models._
import controllers.responses._
class EventsController @Inject() extends Controller{
  
  def list = Action {request => 
    val events: Seq[Event] = ???
    Ok(Json.toJson(SuccessResponse(events)))
  }
  
  def getByID(eventID: Long) = Action { request =>
    val event: Option[Event] = ???
    event.fold{
      NotFound(Json.toJson(ErrorResponse(NOT_FOUND, "No event found")))
    } { e =>
      Ok(Json.toJson(SuccessResponse(e)))
    }
  }
  
  def create = Action(parse.json) { request =>
    
    val incomingBody = request.body.validate[Event]
    
    incomingBody.fold(error => {
      val errorMessage = s"Invalid JSON: ${error}"
      val response = ErrorResponse(ErrorResponse.INVALID_JSON, errorMessage)
    }, event => {
       val createdEvent: Event = ???
       Created(Json.toJson(SuccessResponse(createdEvent)))
    })
    
    val incomingEvent: Event = ???
    val createdEvent: Event = ???
    
    Created(Json.toJson(SuccessResponse(createdEvent)))
  }
  
}