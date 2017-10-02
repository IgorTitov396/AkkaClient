import akka.actor.ActorSystem
import akka.pattern.ask
import scala.concurrent.duration._
import akka.util.Timeout
import book.task2.messages.{GetRequest, SetRequest}

class SClient(remoteAddress: String) {
  private implicit val timeout = Timeout(2 seconds)
  private implicit val system = ActorSystem("LocalSystem")
  private val remoteDb = system.actorSelection(s"akka.tcp://akkademy@$remoteAddress/user/my_bd")
  def set(key: String, value: Any) = {
    remoteDb ? SetRequest(key, value)
  }
  def get(key: String) = {
    remoteDb ? GetRequest(key)
  }
}