package example.timekvstore

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 */
trait TimeKeyValueMap {
  // Stores the key key with the value value at the given time timestamp
  def set(key: String, value: String, timestamp: Int): Unit

  // Returns a value such that set was called previously,
  // with timestamp_prev <= timestamp. If there are multiple such values,
  // it returns the value associated with the largest timestamp_prev.
  // If there are no values, it returns ""
  def get(key: String, timestamp: Int): String
}
