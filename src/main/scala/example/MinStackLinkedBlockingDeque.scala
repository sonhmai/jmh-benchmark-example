package example

import java.util.concurrent.LinkedBlockingDeque

class MinStackLinkedBlockingDeque() extends MinStack {

  private val stack = new LinkedBlockingDeque[Int]()
  private val mins = new LinkedBlockingDeque[Int]()

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