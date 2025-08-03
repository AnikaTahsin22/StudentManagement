package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentManagerTest {
   private StudentManager studentManager;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("After all test");
    }
    @BeforeEach
    void setUp() {
      StudentManager studentManager1=new StudentManager();
    }
    @AfterEach
    void tearDown() {
        System.out.println("After each test");
    }


}