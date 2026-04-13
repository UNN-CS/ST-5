package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AppTest {

   @Test
   void appHasMainMethod() throws NoSuchMethodException {
      Class<App> clazz = App.class;
      assertTrue(clazz.getMethod("main", String[].class).getReturnType().equals(void.class));
   }
}
