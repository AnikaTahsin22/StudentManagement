package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentTest {
    private  Student student1;
    private  Student student2;
    private  Student student3;
    @BeforeEach
    void setUp()
    {
        student1 = new Student("Rubayet",89,90,97);
        student2 = new Student("Nahar",93,92,86);
        student3 =new Student("Umar",90,89,95);
    }
    @Test
    void testAssertion()
    {
        assertEquals(student1.getGrade(),"A+");
        assertTrue(student1.totalMarks()==89+90+97);

        assertTimeout(Duration.ofMillis(100),()-> student1.averageMarks());
    }
    @Test
    void test()
    {
        assertEquals(student2.getGrade(),"A+");
        assertTrue(student1.totalMarks()>student2.totalMarks());
        assertTimeout(Duration.ofMillis(10),()-> student2.averageMarks());
    }
    @Test
    void testNullName() {
        Student s = new Student(null);
        assertNull(s.getName());
    }
    @Test
    void testStudentGradeOutputFormat() {

        List<String> expected = List.of(
                "Student Name: Rubayet",
                "Total Marks: 276",
                "Average: 92.0",
                "Grade: A+"
        );
        List<String> actual = List.of(
                "Student Name: " + student1.getName(),
                "Total Marks: " + student1.totalMarks(),
                "Average: " + student1.averageMarks(),
                "Grade: " + student1.getGrade()
        );
        assertLinesMatch(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Rubayet, 90, 85, 95, A+",
            "Aisha, 70, 75, 65, A",
            "Zayan, 60, 60, 60, B",
            "Sara, 50, 55, 52, C",
            "Nabil, 40, 42, 41, D",
            "FailGuy, 30, 35, 25, F"
    })
    void testGradeCalculation(String name, int bangla, int english, int math, String expectedGrade) {
        Student s = new Student(name, bangla, english, math);
        assertEquals(expectedGrade, s.getGrade());
    }

    @ParameterizedTest
    @CsvSource({
            "Rubayet, 90, 85, 95, 270, 90.0",
            "Aisha, 70, 75, 65, 210, 70.0",
            "Zayan, 60, 60, 60, 180, 60.0"
    })
    void testTotalAndAverageMarks(String name, int bangla, int english, int math, int expectedTotal, double expectedAverage) {
        Student s = new Student(name, bangla, english, math);
        assertEquals(expectedTotal, s.totalMarks());
        assertEquals(expectedAverage, s.averageMarks());
    }

}