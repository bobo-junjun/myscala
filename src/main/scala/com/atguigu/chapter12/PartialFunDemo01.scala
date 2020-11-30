package com.atguigu.chapter12

/**
 * List(1, 2, 3, 4, "abc")
 * 需求：返回一个新集合（2, 3, 4,5）
 */
object PartialFunDemo01 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 1.2 , 3.5, "abc")
    //    定义一个偏函数
    val partialFun = new PartialFunction[Any, Int] {
      override def isDefinedAt(x: Any): Boolean = x.isInstanceOf[Int]

      override def apply(v1: Any): Int = {
        v1.asInstanceOf[Int] + 1
      }
    }

//    可以简写成
   def partialFul2 :  PartialFunction[Any,Any] = {
      case a:Int => a + 1
      case  b:Double => (b * 2)
    }

    //    使用偏函数
    val list2 = list.collect(partialFun)
    println("list2 =" + list2)
    val list3 = list.collect(partialFul2)
    println("list3 =" + list3)



  }
}
