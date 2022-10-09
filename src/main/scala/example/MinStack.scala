package example

trait MinStack {
  // key insight is to remember the min at each step of the stack
  // so when popping the stack we can retrieve the min in O(1) time
  def push(value: Int): Unit
  def pop(): Unit
  def top(): Int
  def getMin(): Int
}