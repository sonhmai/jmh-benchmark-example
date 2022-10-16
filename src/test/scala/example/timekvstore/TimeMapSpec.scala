package example.timekvstore

import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

class TimeMapSpec extends AnyWordSpec with should.Matchers {

  def createImplementation(): TimeKeyValueMap =
    new TimeMap()

  "TimeKeyValueMap" should {
    "work in case 1" in {
      val map = createImplementation()

      map.set("foo", "bar", 1)
      map.get("foo", 1) shouldBe("bar")
      map.get("foo", 3) shouldBe("bar")

      map.set("foo", "bar2", 4)
      map.get("foo", 4) shouldBe ("bar2")
      map.get("foo", 5) shouldBe ("bar2")
    }

    "work in case 2" in {
      val map = createImplementation()
      map.set("love", "high", 10)
      map.set("love", "low", 20)
      map.get("love", 5) shouldBe("")
      map.get("love", 10) shouldBe("high")
      map.get("love", 15) shouldBe("high")
      map.get("love", 20) shouldBe("low")
      map.get("love", 25) shouldBe("low")
    }

  }

}
