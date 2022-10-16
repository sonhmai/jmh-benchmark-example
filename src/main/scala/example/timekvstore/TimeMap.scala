package example.timekvstore

import scala.annotation.tailrec
import scala.collection.mutable

class TimeMap extends TimeKeyValueMap {
  type MapValue = Array[(Int, String)]
  private val state = mutable.HashMap[String, MapValue]()

  def set(key: String, value: String, timestamp: Int): Unit = {
    // TODO - this might have optimized function on a map to offer atomicity
    val newValue: MapValue = state.get(key) match {
      case Some(array) => array :+ (timestamp, value)
      case None => Array[(Int, String)]((timestamp, value))
    }
    state.put(key, newValue)
  }

  def get(key: String, timestamp: Int): String = {
    state.get(key) match {
      case None        => ""
      case Some(array) => getValueNearestTimestampBinarySearch(array, timestamp)
    }
  }

  @tailrec
  private def getValueNearestTimestampLinear(
      array: Array[(Int, String)],
      ts: Int
  ): String = {
    val len = array.length
    if (array.headOption.forall(_._1 > ts)) ""
    else if (array(len-1)._1 <= ts) array(len-1)._2
    else getValueNearestTimestampLinear(array.slice(0, len-1), ts)
  }

  private def getValueNearestTimestampBinarySearch(
      array: Array[(Int, String)],
      ts: Int
  ): String = {
    var ret = ""
    var left = 0
    var right = array.length - 1
    var mid = 0
    while (left <= right) {
      mid = (left + right) / 2
      if (array(mid)._1 > ts) right = mid - 1
      else if (array(mid)._1 <= ts) {
          ret = array(mid)._2
          left = mid + 1
        }
      }
    ret
  }
}
