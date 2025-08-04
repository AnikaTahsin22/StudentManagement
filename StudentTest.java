package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentTest {
    private  Student student1;
    private  Student student2;
    @BeforeEach
    void setUp()
    {
        student1 = new Student("Rubayet",87,90,97);
        student2 = new Student("Nahar",93,90,85);
    }
    @Test
    void testAssertion()
    {
        assertEquals(student1.getGrade(),"A+");
        assertTrue(student1.totalMarks()==87+90+97);
        assertTimeout(Duration.ofMillis(100),()-> student1.averageMarks());
    }
    @Test
    void test()
    {
        assertEquals(student2.getGrade(),"A+");
        assertTrue(student1.totalMarks()>student2.totalMarks());
        assertTimeout(Duration.ofMillis(10),()-> student2.averageMarks());
    }
}