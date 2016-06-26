package models
import org.joda.time.DateTime

case class TicketBlock(
  id: Long,
  eventID: Long,
  name: String,
  productCode: String,
  price: BigDecimal,
  initialSize: Int,
  saleStart: DateTime,
  saleEnd: DateTime)