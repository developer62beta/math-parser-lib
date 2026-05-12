
package com.developer62.parser

class Parser(private val text: String) {

    private val tokens = Lexer(text).getTokens()
    private var pos = 0

    private val current: Token
        get() = tokens[pos]

    fun parse(): Double {
        return expr()
    }

    private fun eat(type: TokenType): Token {
        val token = current
        if (token.type == type) {
            pos++
            return token
        }
        throw Exception("Unexpected token")
    }

    private fun expr(): Double {
        var result = term()

        while (current.type == TokenType.PLUS || current.type == TokenType.MINUS) {
            val token = current
            if (token.type == TokenType.PLUS) {
                eat(TokenType.PLUS)
                result += term()
            } else {
                eat(TokenType.MINUS)
                result -= term()
            }
        }
        return result
    }

    private fun term(): Double {
        var result = factor()

        while (current.type == TokenType.MUL || current.type == TokenType.DIV || current.type == TokenType.PERCENT) {
            val token = current
            if (token.type == TokenType.MUL) {
                eat(TokenType.MUL)
                result *= factor()
            } else if(token.type == TokenType.DIV){
                eat(TokenType.DIV)
                result /= factor()
            }else{
                eat(TokenType.PERCENT)
                result = (factor()/result)*100
            }
        }
        return result
    }

    private fun factor(): Double {
        val token = current

        return when (token.type) {
            TokenType.NUMBER -> {
                eat(TokenType.NUMBER)
                token.value!!.toDouble()
            }

            TokenType.LPAREN -> {
                eat(TokenType.LPAREN)
                val result = expr()
                eat(TokenType.RPAREN)
                result
            }

            TokenType.MINUS -> {
                eat(TokenType.MINUS)
                -factor()
            }

            else -> throw Exception("Invalid syntax")
        }
    }
}
