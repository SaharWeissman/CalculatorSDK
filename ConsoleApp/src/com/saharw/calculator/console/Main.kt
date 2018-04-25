package com.saharw.calculator.console

import com.saharw.calculatorsdk.core.Calculator

/**
 * Created by Sahar on 04/22/2018.
 */
val input = "(1+2)/(2+2)"

fun main(args:Array<String>) {
    var calculator = Calculator()
    println(calculator.eval(input))
}