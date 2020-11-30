package com.atguigu.chapter15.customercrm.view

import com.atguigu.chapter15.customercrm.bean.Customer
import com.atguigu.chapter15.customercrm.service.CustomerService

import scala.io.StdIn

/**
 * 思路分析
 * 完成显示主菜单,退出
 * 1. 将主菜单的显示放入到 while
 * 2. 用户可以根据输入，选择自己的操作
 * 3. 如果输入 5 退出
 * 效果图
 * -----------------客户信息管理软件-----------------
 * 1 添 加 客 户
 * 2 修 改 客 户
 * 3 删 除 客 户
 * 4 客 户 列 表
 * 5 退 出
 * 请选择(1-5)：_
 */
class CustomerView {
  //定义一个循环变量，控制是否退出 while
  var loop = true
  //定义一个 key 用于接收用户输入的选项
  var key: Int = _
  val customerService = new CustomerService()

  def mainMenu(): Unit = {
    do {
      println("-----------------客户信息管理软件-----------------")
      println("       1 添 加 客 户")
      println("       2 修 改 客 户")
      println("       3 删 除 客 户")
      println("       4 客 户 列 表")
      println("       5 退 出")
      println("       请选择(1-5)：")
      key = StdIn.readInt()
      key match {
        case 1 => this.add()
        case 2 => println("修 改 客 户")
        case 3 => this.del()
        case 4 => this.list()
        case 5 => this.loop = false
      }
    } while (loop)
    println("你退出了软件")
  }

  //在 CustomerView.scala 增加了 list 方法，并调用
  def list(): Unit = {
    println()
    println("---------------------------客户列表---------------------------")
    println("编号\t\t 姓名\t\t 性别\t\t 年龄\t\t 电话\t\t 邮箱")
    //for 遍历
    //1.获取到 CustomerSerivce 的 customers ArrayBuffer
    val customers = customerService.list()
    for (customer <- customers) {
      //      这里我当然也可以拼接的遍历打印出来。
      //      不过最好的还是我们重写 Customer 的 toString 方法，返回信息(并且格式化)
      println(customer)
    }
  }

  /**
   * 添加客户的方法  添加属性
   */
  def add(): Unit = {
    println()
    println("---------------------添加客户---------------------")
    println("姓名：")
    val name = StdIn.readLine()
    println("性别：")
    val gender = StdIn.readChar()
    println("年龄：")
    val age = StdIn.readShort()
    println("电话：")
    val tel = StdIn.readLine()
    println("邮箱：")
    val email = StdIn.readLine()
    //构建对象
    val customer = new Customer(name, gender, age, tel, email)
    customerService.add(customer)
    println("---------------------添加完成---------------------")
  }

  /**
   * 删除客户信息的功能
   */
  def del(): Unit = {
    println("---------------------删除客户---------------------")
    println("请选择待删除客户编号(-1 退出)：")
    val id = StdIn.readInt()
    if(id == -1) {
      println("---------------------删除没有完成---------------------")
      return
    }
    println("请你确认是否要删除（y/n）")
    val choice = StdIn.readChar().toLower
    if(choice == 'y'){
      if(customerService.del(id))
        println("---------------------删除完成---------------------")
      return
    }
  }
  println("---------------------删除没有完成---------------------")
}
