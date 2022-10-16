package example.minstack

class MinStackArrayDeque() extends MinStack {

  private val stack = new java.util.ArrayDeque[Int]()
  private val mins = new java.util.ArrayDeque[Int]()

  // TODO - how to abstract out the methods below for Deque
  //  This will be repetitive amongst MinStack impls using classes impl iava.util.Deque<E>
  def push(value: Int): Unit = {
    stack.push(value)
    val nextMin: Int = Option(mins.peekFirst()) match {
      // first element of both stacks
      case Some(currentMin) if currentMin <= value => currentMin
      case _ => value
    }
    mins.push(nextMin)
  }

  def pop(): Unit = {
    stack.pop()
    mins.pop()
  }

  def top(): Int = {
    stack.peekFirst()
  }

  def getMin(): Int = {
    mins.peekFirst()
  }

}