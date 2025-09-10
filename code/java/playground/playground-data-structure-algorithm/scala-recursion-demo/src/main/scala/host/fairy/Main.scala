/*
* @software: IntelliJ IDEA
* @author: Lionel Johnson
* @contact: https://fairy.host
* @organization: https://github.com/FairylandFuture
* @datetime: 2025-09-10 14:55:14 UTC+08:00
* */
package host.fairy

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    println(sum(10000000, 0))
  }

  @tailrec
  def sum(n: Long, accumulator: Long): Long = {
    if (n == 1) {
      return 1 + accumulator
    }

    sum(n - 1, n + accumulator)
  }
}
