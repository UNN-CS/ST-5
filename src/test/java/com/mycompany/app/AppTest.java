package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AppTest {
    @Test
    void mainRunsWithoutErrors() {
        assertDoesNotThrow(() -> App.main(new String[0]));
    }
}
