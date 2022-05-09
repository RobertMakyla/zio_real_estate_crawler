package zio_real_estate_crawler.http

import zio.{Has, ZIO, ZLayer}

import scala.util.Try

case class Port(value: Int)

object Port {

  val fromSystemPropertyOrElse8080: ZLayer[Any, Throwable, Has[Port]] =
    ZIO.effect(
      Port(
        Try(System.getProperty("http.port").toInt).getOrElse(8080)
      )
    ).toLayer

}
