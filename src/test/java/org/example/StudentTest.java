package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
class StudentTest {
    private Student student;
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
        student =new Student("anika",60,60,60);

    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test");

    }

    @Test
    void  testTotalMarks() {
        assertEquals(190, student.totalMarks(),"total marks should be 180");
    }

    @Test
    void testAverageMarks() {

    }
}