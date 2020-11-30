package com.atguigu.chapter15.customercrm.app

import com.atguigu.chapter15.customercrm.view.CustomerView

/**
 * 主程序入口
 */
object Customercrm {
  def main(args: Array[String]): Unit = {
    new CustomerView().mainMenu()
  }
}
