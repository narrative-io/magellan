package magellan.encoders

import magellan._
import org.apache.spark.sql.Encoder
import org.apache.spark.sql.catalyst.analysis.GetColumnByOrdinal
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.catalyst._
import org.apache.spark.sql.types._

import scala.reflect._
import scala.reflect.runtime.universe

object Encoders {

  implicit def encoderForPoint: Encoder[Point] = {

    val udt =  new PointUDT()
    val sqlType = udt.sqlType

    ExpressionEncoder[Point](
      objSerializer = SerializerBuildHelper.createSerializerForUserDefinedType(BoundReference(0, ObjectType(classOf[Point]), nullable = true), udt, udt.getClass)
        ,
      objDeserializer = MagellanDeserializer(
          GetColumnByOrdinal(0, sqlType), classOf[Point]),
      clsTag = classTag[Point])
  }

  implicit def encoderForPolygon: Encoder[Polygon] = {
    val udt =  new PolygonUDT()
    val sqlType = udt.sqlType

    ExpressionEncoder[Polygon](
      objSerializer = 
        SerializerBuildHelper.createSerializerForUserDefinedType(BoundReference(0, ObjectType(classOf[Polygon]), nullable = true), udt, udt.getClass),
      objDeserializer =
        MagellanDeserializer(
          GetColumnByOrdinal(0, sqlType), classOf[Polygon]),
      clsTag = classTag[Polygon])
  }

  implicit def encoderForPolyLine: Encoder[PolyLine] = {
    val udt =  new PolyLineUDT()
    val sqlType = udt.sqlType

    ExpressionEncoder[PolyLine](
      objSerializer = 
        SerializerBuildHelper.createSerializerForUserDefinedType(BoundReference(0, ObjectType(classOf[PolyLine]), nullable = true), udt, udt.getClass),
      objDeserializer =
        MagellanDeserializer(
          GetColumnByOrdinal(0, sqlType), classOf[PolyLine]),
      clsTag = classTag[PolyLine])
  }

}
