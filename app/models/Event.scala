package models
import org.joda.time.DateTime
import play.api.libs.json.{Json, Format}

case class Event(
  id: Option[Long],
  name: String,
  start: DateTime,
  end: DateTime,
  address: String,
  city: String,
  state: String,
  country: String)
  
object Event {
  implicit val format: Format[Event] = Json.format[Event]
}