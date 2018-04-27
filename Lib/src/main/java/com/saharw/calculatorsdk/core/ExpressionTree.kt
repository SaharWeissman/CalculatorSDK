package main.core

import util.CharUtils
import java.util.*

class ExpressionTree {

    private val emptyTreeValue: Float = 0F
    private val divisionByZeroValue: Float = Float.MIN_VALUE

    fun buildTree(expressionPostfix: String) : Node {
        var nodeStack = Stack<Node>()
        var n : Node? = null
        var nLeft : Node? = null
        var nRight : Node? = null
        var nodeValue = StringBuilder()
        // start iterating over every char of input & construct nodes accordingly
        for(i in 0 until expressionPostfix.length){
            var currChar = expressionPostfix[i]

            // if char is not an operator - construct node & add to stack
            if(!CharUtils.isOperator(currChar)){
                if(currChar == ' ' && nodeValue.trim().length > 0){
                    n = Node(nodeValue.toString())
                    nodeStack.push(n)
                    nodeValue.delete(0, nodeValue.length)
                }else {
                    nodeValue.append(currChar)
                }

            }else { // char is an operator

                if(nodeValue.isNotEmpty()){
                    n = Node(nodeValue.toString())
                    nodeStack.push(n)
                    nodeValue.delete(0, nodeValue.length)
                }

                n = Node(currChar.toString())

                // pop 2 operands
                nRight = nodeStack.pop()
                nLeft = nodeStack.pop()

                // make children of operator node
                n.right = nRight
                n.left = nLeft

                // push operator node to stack
                nodeStack.push(n)
            }
        }

        if(nodeValue.isNotEmpty()){
            n = Node(nodeValue.toString())
            nodeStack.push(n)
            nodeValue.delete(0, nodeValue.length)
        }

        // return root
        n = nodeStack.peek()
        nodeStack.pop()
        return n
    }

    fun evaluate(node: Node?) : Float {
        if(node == null){
            return emptyTreeValue
        }else {

            // if leaf - return value
            if(node.left == null && node.right == null){
                return node.`val`.toFloat() // important! otherwise value will be the char value from ASCII table!!
            }else {

                // recursively call eval on left & right children
                var leftEval = evaluate(node.left)
                var rightEval = evaluate(node.right)

                /* since this node is not leaf, it must be an operand (due to the method we are building the tree) - we need
                to determine which operand it is in order to apply it on left & right eval
                 */
                if(node.`val` == "+"){
                    return leftEval + rightEval
                }else if (node.`val` == "-"){
                    return leftEval - rightEval
                }else if (node.`val` == "*"){
                    return leftEval * rightEval
                }else {
                    if(rightEval != 0F){
                        return leftEval / rightEval
                    }else {
                        return divisionByZeroValue
                    }
                }
            }
        }
    }

    fun printInorder(root : Node?, string: StringBuilder) : String{
        if(root == null){
            return string.toString()
        }else {
            printInorder(root.left, string)
            string.append("${root.`val`} ")
            printInorder(root.right, string)
        }
        return string.toString()
    }
}