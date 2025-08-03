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

    @Test
    void testFail1() {
        Student student= new Student("Mahi",-10,40,50);
        if(student.getBangla()<0){
            fail("Bangla marks should not be negative");
        }

    }
    @Test
    void testFail2() {
        Student student= new Student("Mahi",-10,-40,-50);
        if(student.averageMarks()<0){
            fail("Average marks should not be negative");
        }

    }

    @Test
    void testGrade() {
        Student student1 = new Student("Tashnim", 80, 83, 75);
        Student student2 = new Student("Anika", 30, 35, 20);
        assertEquals("A", student1.getGrade(), "Grade should be A");
        assertEquals("F", student2.getGrade(), "Grade should be F");
        assertNotEquals("A+", student1.getGrade(), "Grade is not A+");
    }



}