package com.saharw.calculator.console

import core.ExpressionTree
import util.StringUtils

/**
 * Created by Sahar on 04/22/2018.
 */
val input = "1 + 2 / 3"

fun main(args:Array<String>) {
    println("input: $input")

    // convert to postfix
    var postfix = StringUtils.convertInfixToPostfix(input)
    println("postfix: $postfix")
    var expTree = ExpressionTree()
    var root = expTree.buildTree(postfix)
    println("inorder: ${expTree.printInorder(root,StringBuilder())}")

    // check evaluate method
    println("eval: ${expTree.evaluate(root)}")
}