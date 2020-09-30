package magellan.encoders

import magellan._
import org.apache.spark.sql.Encoder
import org.apache.spark.sql.catalyst.analysis.GetColumnByOrdinal
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.types._

import scala.reflect._
import scala.reflect.runtime.universe

object Encoders {


  implicit def encoderForPoint: Encoder[Point] = {
    val sqlType = new PointUDT().sqlType

    ExpressionEncoder[Point](
      objSerializer = 
        MagellanSerializer(
          BoundReference(0, ObjectType(classOf[Point]), nullable = true), sqlType),
      objDeserializer =
        MagellanDeserializer(
          GetColumnByOrdinal(0, sqlType), classOf[Point]),
      clsTag = classTag[Point])
  }

  implicit def encoderForPolygon: Encoder[Polygon] = {
    val sqlType = new PolygonUDT().sqlType
    ExpressionEncoder[Polygon](
      objSerializer = 
        MagellanSerializer(
          BoundReference(0, ObjectType(classOf[Polygon]), nullable = true), sqlType),
      objDeserializer =
        MagellanDeserializer(
          GetColumnByOrdinal(0, sqlType), classOf[Polygon]),
      clsTag = classTag[Polygon])
  }

  implicit def encoderForPolyLine: Encoder[PolyLine] = {
    val sqlType = new PolyLineUDT().sqlType
    ExpressionEncoder[PolyLine](
      objSerializer = 
        MagellanSerializer(
          BoundReference(0, ObjectType(classOf[PolyLine]), nullable = true), sqlType),
      objDeserializer =
        MagellanDeserializer(
          GetColumnByOrdinal(0, sqlType), classOf[PolyLine]),
      clsTag = classTag[PolyLine])
  }

}
