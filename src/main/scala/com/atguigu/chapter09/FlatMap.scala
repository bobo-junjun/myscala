package com.atguigu.chapter09

object FlatMap {
  def main(args: Array[String]): Unit = {
    val name = List("shajun", "baobao", "xiaoming")
    val name2 = List("shajun", List("baobao", "weixiaobao"), "xiaoming")


    //字符串本身就是个集合
    //    val list1 = name.flatMap(upper)
    //    println("list1 ="+list1)
    //    只能扁平一级
    //    val list2= name2.flatMap(upper)
    //    println("list2 ="+list2)
    val myList = MyList()
    val myList2 = myList.map(multiple)
    println("myList2=" + myList2)

  }

  //转为大写的函数
  def upper(s: String): String = {
    s.toUpperCase
  }

  def multiple(n:Int): Int = {
    println("multiple 被调用~~")
    2 * n
  }
}
class MyList {
  val list1 = List(3,5,7,9)
  //新的集合
  var list2 = List[Int]()
  //写 map
  def map(f: Int=>Int): List[Int] = {
    //遍历集合
    for (item <- this.list1) {
      //过滤，扁平化。。。
      list2 = list2 :+ f(item)
    }
    list2
  } }

object MyList {
  def apply(): MyList = new MyList()
}