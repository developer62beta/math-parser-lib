
package com.developer62.parser

class Lexer(private val text: String) {
    private var pos = 0

    private val current: Char?
        get() = if (pos < text.length) text[pos] else null

    fun getTokens(): List<Token> {
        val tokens = mutableListOf<Token>()

        while (current != null) {
            when {
                current!!.isWhitespace() -> pos++

                current!!.isDigit() || current == '.' -> tokens.add(number())

                current == '+' -> {
                    tokens.add(Token(TokenType.PLUS, "+"))
                    pos++
                }

                current == '-' -> {
                    tokens.add(Token(TokenType.MINUS, "-"))
                    pos++
                }

                current == '*' -> {
                    tokens.add(Token(TokenType.MUL, "*"))
                    pos++
                }

                current == '/' -> {
                    tokens.add(Token(TokenType.DIV, "/"))
                    pos++
                }

                current == '%' -> {
                    tokens.add(Token(TokenType.PERCENT, "%"))
                    pos++
                }

                current == '(' -> {
                    tokens.add(Token(TokenType.LPAREN, "("))
                    pos++
                }

                current == ')' -> {
                    tokens.add(Token(TokenType.RPAREN, ")"))
                    pos++
                }

                else -> throw Exception("Invalid char: $current")
            }
        }

        tokens.add(Token(TokenType.EOF))
        return tokens
    }

    private fun number(): Token {
        val start = pos
        while (current != null && (current!!.isDigit() || current == '.')) {
            pos++
        }
        return Token(TokenType.NUMBER, text.substring(start, pos))
    }
}
