package core

import util.StringUtils

/**
 * Created by Sahar on 04/22/2018.
 */
class Calculator() {

    var infixExpression : StringBuilder = StringBuilder()
    var expressionTree : ExpressionTree = ExpressionTree()
    var root : Node? = null

    fun append(str: String) : String {
        infixExpression.append(str)

        // update expression tree
        root = expressionTree.buildTree(StringUtils.convertInfixToPostfix(infixExpression.toString()))
        return infixExpression.toString()
    }

    fun eval() : Float {
        return expressionTree.evaluate(root)
    }

    fun getLastOperand() : String? {
        var res : String? =  null
        if(root != null){
            res = root!!.`val`.toString()
        }
        return res
    }
}