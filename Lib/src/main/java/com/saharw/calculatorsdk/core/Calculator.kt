package com.saharw.calculatorsdk.core

import com.saharw.calculatorsdk.util.StringUtils

/**
 * Created by Sahar on 04/22/2018.
 */
class Calculator {

    var infixExpression : StringBuilder = StringBuilder()
    var expressionTree : ExpressionTree = ExpressionTree()
    var root : Node? = null

    fun eval(infixExpression : String) : Float {
        this.infixExpression.delete(0, this.infixExpression.length)
        this.infixExpression.append(infixExpression)

        // update expression tree
        root = expressionTree.buildTree(StringUtils.convertInfixToPostfix(this.infixExpression.toString()))
        return expressionTree.evaluate(root)
    }
}