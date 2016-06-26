package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json.Json
import models._

class EventsController @Inject() extends Controller{
  
  def list = Action {request => 
    val events: Seq[Event] = ???
    Ok(Json.toJson(events))
  }
  
  def getByID(eventID: Long) = Action { request =>
    val event: Option[Event] = ???
    event.fold{
      NotFound(Json.toJson("No event found"))
    } { e =>
      Ok(Json.toJson(e))
    }
  }
  
  def create = Action { request =>
    
    val incomingEvent: Event = ???
    val createdEvent: Event = ???
    
    Created(Json.toJson(createdEvent))
  }
  
}