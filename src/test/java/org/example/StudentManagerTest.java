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
        manager.addStudent("Anika",80,87,90);
        manager.addStudent("Bob", 88, 92, 75);
        manager.addStudent("Tashnim",29,30,23);

    }
    @AfterEach
    void tearDown() {
        System.out.println("After each test");
    }

    @Test
    void testAddStudents() {
      List<Student>students=manager.getAllStudents();
      assertEquals(3,students.size());

    }

    @Test
    void testHighestMarks(){

        String highest = manager.getHighestMarks();
        assertTrue(highest.contains("English: 92"));

    }

    @Test
    void testTopper(){
        manager.addStudent("bob",90,90,93);
        manager.addStudent("tisha",60,55,78);
        String topper=manager.getTopper();
        assertFalse(topper.contains("tisha"),"Tisha is not topper");
        assertTrue(topper.contains("bob"),"Bob should be topper");

    }

    @Test
    void  testSameNotSame() {
        Student s1=new Student("bob",90,90,93);
        Student s2=new Student("tisha",60,55,78);
        Student s3=s1;
        assertSame(s1,s3);
        assertNotSame(s1,s2);


    }



}