package controllers.responses
import play.api.libs.json.{Json, Format, Writes}
import play.api.libs.json.{JsValue, JsNull}

case class ErrorResult(status: Int,message: String)
