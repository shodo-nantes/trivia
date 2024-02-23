package com.adaptionsoft.games.trivia.runner

import com.adaptionsoft.games.trivia.runner.GameRunner.aGame
import com.adaptionsoft.games.uglytrivia.Game
import java.util.*

object GameRunner {
    var notAWinner: Boolean = false

    fun aGame() {
        val aGame = Game()

        aGame.add("Chet")
        aGame.add("Pat")
        aGame.add("Sue")

        val rand = Random(1)

        do {

            aGame.roll(rand.nextInt(5) + 1)

            if (rand.nextInt(9) == 7) {
                GameRunner.notAWinner = aGame.wrongAnswer()
            } else {
                GameRunner.notAWinner = aGame.wasCorrectlyAnswered()
            }


        } while (GameRunner.notAWinner)
    }

}

fun main(args: Array<String>) {
    aGame()
}


