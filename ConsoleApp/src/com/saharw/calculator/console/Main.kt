package com.saharw.calculator.console

import main.core.Calculator

/**
 * Created by Sahar on 04/22/2018.
 */
val input = "12+2"

fun main(args:Array<String>) {
    var calculator = Calculator()
    println(calculator.eval(input))
}