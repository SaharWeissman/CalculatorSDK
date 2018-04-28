package util

import java.util.*

object StringUtils {

    fun covertInfixToPrefix(expression: String) : String {
        var reversed = expression.reversed()
        var reversedFixed = StringBuilder()
        var i = 0
        while (i < reversed.length) {

            if (expression[i] === '(') {
                reversedFixed.append(')')
                i++
            } else if (expression[i] === ')') {
                reversedFixed.append('(')
                i++
            }else {
                reversedFixed.append(reversed[i])
                i++
            }
        }
        var postfix = convertInfixToPostfix(reversedFixed.toString())
        return postfix.reversed()
    }

    fun convertInfixToPostfix(expression: String) : String {
        var postfix = StringBuilder()
        var operatorStack = Stack<Char>()
        for (i in 0 until expression.length) {
            var currChar = expression[i]
            if(!CharUtils.isOperator(currChar)){
                postfix.append(currChar)
            }else if (currChar == ')'){
                while(operatorStack.peek() != '('){
                    postfix.append(operatorStack.pop())
                }
                operatorStack.pop()
            }else {
                postfix.append(' ')
                while(operatorStack.isNotEmpty() && currChar != '(' && CharUtils.precedence(operatorStack.peek()) >= CharUtils.precedence(currChar)){
                    postfix.append(operatorStack.pop())
                }
                operatorStack.push(currChar)
            }
        }

        // drain stack for last operator (if exist)
        while (operatorStack.isNotEmpty()) {
            postfix.append(operatorStack.pop())
        }
        return postfix.toString()
    }
}