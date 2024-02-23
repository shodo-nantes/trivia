package com.adaptionsoft.games.trivia

import com.adaptionsoft.games.trivia.runner.GameRunner
import org.approvaltests.Approvals
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class AGameTest {

    val capturedOutput = ByteArrayOutputStream()
    var originalOutput: PrintStream? = null

    @BeforeEach
    fun captureStandardOutput() {
        originalOutput = System.out
        System.setOut(PrintStream(capturedOutput))
    }

    @AfterEach
    fun resetStandardOutput() {
        System.setOut(originalOutput)
    }

    @Test
    fun salesForecast() {
        val gameRunner = GameRunner
        gameRunner.aGame()
        Approvals.verify(capturedOutput)
    }

}