import akka.actor.ActorSystem
import akka.util.Timeout
import book.task2.messages.SetRequest
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.duration._

class MyTest extends FunSpecLike with Matchers {
  private implicit val timeout = Timeout(2 seconds)
  private implicit val system = ActorSystem("LocalSystem")
  private val remoteDb = system.actorSelection("akka.tcp://akkademy@127.0.0.1:2552/user/my_bd")
  describe("My test") {
    it("Test 1") {
      remoteDb ! SetRequest("Hi", "Hi2")
      "123" should equal("123")
    }
  }
}