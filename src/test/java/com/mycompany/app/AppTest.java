package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void mainPrintsDemoCalculation() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            App.main(new String[0]);
        } finally {
            System.setOut(originalOut);
        }

        String text = output.toString(StandardCharsets.UTF_8);
        assertTrue(text.contains("Sqrt of 2.0 ="));
    }
}
