package example.minstack
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class MinStackLinkedBlockingDequeSpec extends AnyFlatSpec with Matchers {
  "stack" should "work in case 1 " in {
    val stack = new MinStackLinkedBlockingDeque()
    stack.push(-2)
    stack.push(0)
    stack.push(-3)
    stack.getMin() shouldBe -3
    stack.pop()
    stack.top() shouldBe 0
    stack.getMin() shouldBe -2
  }

  "stack" should "work in case 2" in {
    val stack = new MinStackLinkedBlockingDeque()
    stack.push(2)
    stack.push(0)
    stack.push(3)
    stack.push(0)
    stack.getMin() shouldBe 0
    stack.pop()
    stack.getMin() shouldBe 0
    stack.pop()
    stack.getMin() shouldBe 0
    stack.pop()
    stack.getMin() shouldBe 2
  }
}
