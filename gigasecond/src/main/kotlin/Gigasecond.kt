import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.temporal.ChronoUnit
import java.time.temporal.Temporal


class Gigasecond (localDateTime: LocalDateTime){
  private val gigasecond:Long = 1_000_000_000
  val date = localDateTime.plus(gigasecond, ChronoUnit.SECONDS)

  constructor(localDate:LocalDate) : this(localDate.atStartOfDay())

  constructor() : this(LocalDate.of(2024, Month.JANUARY, 25)){
    println("HEY I HAVE BEEN CALLED UPON FOR ONCE IN ME LIFETIME!")
    dummy(1)
    dummy("AB")
    dummy(1.23)
  }

}

class dummy() {
  constructor(i:Int): this() {println("INTEGER TYPE CONSTRUCTOR CALLED with value -> $i")}
  constructor(i:String): this() {println("STRING TYPE CONSTRUCTOR CALLED with value -> $i" )}
  constructor(i:Double): this() {println("DOUBLE TYPE CONSTRUCTOR CALLED with value -> $i")}
}

fun main(){
  dummy(1)
  dummy("AB")
  dummy(1.23)
}