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
        var postfix  = StringBuilder()
        var operatorStack = Stack<Char>()
        var poppedChar = ' '
        for(i in 0 until expression.length){
            var currChar = expression[i]

            // if char is not operator - concatenate to String
            if(!CharUtils.isOperator(currChar)){
                postfix.append(currChar)
            }

            else if(currChar == ')'){
                while(poppedChar != '('){
                    poppedChar = operatorStack.pop()
                    postfix.append(poppedChar)
                }
            }

             else {
                while(operatorStack.isNotEmpty() && currChar != '(' && CharUtils.precedence(operatorStack.peek()) >= CharUtils.precedence(currChar)){
                    postfix.append(operatorStack.pop())
                }
                operatorStack.push(currChar)
            }
        }

        // pop any remaining operator
        while(operatorStack.isNotEmpty()){
            postfix.append(operatorStack.pop())
        }

        return postfix.toString()
    }
}