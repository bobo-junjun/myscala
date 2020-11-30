package com.atguigu.chapter01

import scala.io.StdIn


object StandardIn {
  def main(args: Array[String]): Unit = {
    println("请输入你的名字")
    val line = StdIn.readLine()
    println("your name :"+line)
  }
}
