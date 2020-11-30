package com.atguigu.chapter15.customercrm.service

import com.atguigu.chapter15.customercrm.bean.Customer

import scala.collection.mutable.ArrayBuffer
import  util.control.Breaks._
class CustomerService {
  var customerNum = 1
  //customers 是存放客户的，这里我们先初始化,为了测试
  val customers = ArrayBuffer(new Customer(1,"tom",'男',10,"110","tom@qq.com"))
//  显示客户功能
  /**
   * 思路：1.接受4，显示客户列表
   * 2.调用CUstomerService的方法list
   * 3.需要一个CustomerService的对象（属性）
   * @return
   */
  def list(): ArrayBuffer[Customer] ={
    this.customers
  }
//  添加客户功能  添加对象
  /**
   * 1.编写一个add方法，接受一个customer对象
   * 2.加入到ArrayBuffer中
   *以添加的客户是第几个作为他的id
   */
def add(customer:Customer): Boolean = {
//  设置id
  customerNum += 1
  customer.id = customerNum
  //加入到customers中
  customers.append(customer)
  true
}

  /**
   * 写一个findIndexById方法，（因为索引和id不一定相同）
   */
  def findIndexById(id :Int) = {
    //默认-1,如果找到就改成对应,如果没有找到，就返回-1
    var index = -1
    breakable{
    for (i <- 0 until customers.length) {
      if(customers(i).id == id){  //找到
            index = i
        break()
      }
    }

    }
      index
  }

  /**
   * 定义一个根据id 中间引用根据id找索引的方法  删除的方法
   */

  def del(id:Int): Boolean ={
    val index = findIndexById(id)
    if(index != -1){
//      删除
      customers.remove(index)
      true
    }else{
      false
    }
  }

}
