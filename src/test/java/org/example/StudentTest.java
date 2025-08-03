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

        student =new Student("samiha",50,70,45);

    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test");

    }

    @Test
    void  testTotalMarks() {
        student =new Student("anika",60,60,60);
        assertEquals(180, student.totalMarks(),"total marks should be 180");

    }

    @Test
    void testAverageMarks() {
        assertEquals(55.0,student.averageMarks(),"Average marks should be 55.0");

    }


}