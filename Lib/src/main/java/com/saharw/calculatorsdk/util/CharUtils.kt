package util

object CharUtils {

    fun isOperator(c: Char) : Boolean {
        return precedence(c) > 0
    }

    fun precedence(c : Char) : Int {
        return if(c == '(' || c ==')') 1
        else if(c == '-' || c =='+') 2
        else if(c == '*' || c =='/') 3
        else 0
    }
}