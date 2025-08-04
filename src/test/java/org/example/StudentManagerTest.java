package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Duration;
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
    void testNotEqals() {
        Student s = manager.getAllStudents().get(0);
        assertNotEquals(100, s.getBangla(), "Bangla mark should not be 100");

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
    @Test
    void testNull() {
        Student s=null;
        assertNotNull(s);
    }

    @Test
    void testNotNull() {
        Student s=manager.getAllStudents().get(0);
        assertNotNull(s);
    }

    @Test
    void testDoesNotThrow() {
        assertDoesNotThrow(() -> {
            manager.addStudent("Samiha", 75, 80, 90);
        });
    }

@Test
void testTimeout(){
        assertTimeout(Duration.ofMillis(100),()->{
            manager.getTopper();
        });
}




    @ParameterizedTest
    @CsvSource({
            "Anika, 85, 90, 88",
            "Samiha, 78, 91, 89",
            "Mahi, 92, 88, 77"
    })
    void testCsv(String name, int bangla, int english, int math) {
        StudentManager manager = new StudentManager();
        manager.addStudent(name, bangla, english, math);

        Student student = manager.getAllStudents().get(0);
        assertEquals(name, student.getName());
        assertEquals(bangla, student.getBangla());
        assertEquals(english, student.getEnglish());
        assertEquals(math, student.getMath());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/students.csv", numLinesToSkip = 1)
    void testFromCsv(String name, int bangla, int english, int math) {
        StudentManager manager = new StudentManager();
        manager.addStudent(name, bangla, english, math);
        Student s = manager.getAllStudents().get(0);

        assertEquals(name, s.getName());
    }









}
