

object ArrayPracticeScala{

  def search(nums: Array[Int], target: Int): Int = {
    var left = 0
    var right = nums.length - 1
    while (left <= right) {
      var mid = left + ((right - left) / 2)
      if (target == nums(mid)) {
        return mid
      } else if (target < nums(mid)) {
        right = mid - 1
      } else {
        left = mid + 1
      }
    }
    -1
  }

}