package br.com.gustavo

import java.util.*

class ProcessResult{
    val deque = ArrayDeque<Int>()

    fun receiveValues(amoutOfValues: Int){
        for (i in 1..amoutOfValues) {
            deque.addLast(i)
        }
    }
    fun manipulateQueue(amoutOfValues: Int) {
        receiveValues(amoutOfValues)

        print("Discarded cards: ")
        while (deque.size > 1) {
            if (deque.size > 2)
                print("${deque.first()}, ")
            else
                print("${deque.first()}\n")
            deque.removeFirst()
            deque.addLast(deque.first())
            deque.removeFirst()
        }
        print("Remaining card: ${deque.first()}\n")
        deque.clear()
    }
}

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    val processResult = ProcessResult()
    var amoutOfValues = reader.nextInt()

    while(amoutOfValues != 0) {
        processResult.manipulateQueue(amoutOfValues)
        amoutOfValues = reader.nextInt()
    }
}