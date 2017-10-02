import akka.actor.ActorSystem
import akka.util.Timeout

import scala.concurrent.duration._

object Main extends App {
  private implicit val timeout = Timeout(2 seconds)
  private implicit val system = ActorSystem("LocalSystem")
  private val remoteDb = system.actorSelection("akka.tcp://akkademy@127.0.0.1:2552/user/my_bd")
  println(remoteDb.pathString)
  remoteDb ! "Hi"
}