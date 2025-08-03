package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentManagerTest {
   private StudentManager manager;

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
        manager = new StudentManager();
    }
    @AfterEach
    void tearDown() {
        System.out.println("After each test");
    }

    @Test
    void testAddStudents() {
       manager.addStudent("Anika",80,87,90);
      List<Student>students=manager.getAllStudents();
      assertNotNull(students);
      assertEquals(1,students.size());
    }
    @Test
    void testHighestMarks(){
        manager.addStudent("Anika",80,87,90);
        manager.addStudent("Bob", 88, 92, 75);
        manager.addStudent("Tashnim",29,30,23);
        String result= manager.getHighestMarks();
        assertTrue(result.contains("Bangla: 90"));

    }
    @ParameterizedTest
    @ValueSource(doubles = {85.0,75.0,65.0,43.0,30.0} )
    void testGrade(double average){
        String grade;
        if (average>=80 ) grade="A+";
        else if (average >= 70) grade = "A";
        else if (average >= 60) grade = "B";
        else if (average >= 50) grade = "C";
        else if (average >= 40) grade = "D";
        else grade = "F";
        Student s=new Student("Mahi",(int)average,(int)average,(int)average );
        assertEquals(grade,s.getGrade(),"Grade sholud match average");

    }


}