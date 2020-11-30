package com.atguigu.chapter15.customercrm.bean

class Customer {
  //属性
  var id: Int = _
  var name: String = _
  var gender: Char = _
  var age: Short = _
  var tel: String = _
  var email: String = _

  //  首先设计一个辅助构造器，有需要的话在设计一个主构造器
  def this(id: Int, name: String, gender: Char, age: Short
           , tel: String, email: String) {
    this //调用主构造器
    this.id = id
    this.name = name
    this.gender = gender
    this.age = age
    this.tel = tel
    this.email = email
  }

  //在来一个辅助构造器   不用穿id的
  def this(name: String, gender: Char, age: Short
           , tel: String, email: String) {
    this //调用主构造器
    this.name = name
    this.gender = gender
    this.age = age
    this.tel = tel
    this.email = email
  }

  override def toString: String = {
    this.id + "\t\t" + this.name + "\t\t" + this.gender +
      "\t\t" + this.age + "\t\t" + this.tel + "\t\t" + this.email
  }
}
