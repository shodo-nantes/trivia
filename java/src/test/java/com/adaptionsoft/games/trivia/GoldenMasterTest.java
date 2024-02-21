package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.Game;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GoldenMasterTest {


    final ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
    PrintStream originalOutput;

    @BeforeEach
    void captureStandardOutput() {
        originalOutput = System.out;
        System.setOut(new PrintStream(capturedOutput));
    }

    @AfterEach
    void resetStandardOutput() {
        System.setOut(originalOutput);
    }

    @Test
    void salesForecast() {
        GameRunner.run();
        Approvals.verify(capturedOutput);
    }

}
