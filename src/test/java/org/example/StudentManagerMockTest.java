package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StudentManagerMockTest {
@Mock
    private StudentManager manager;
@InjectMocks
    private StudentManager service=new StudentManager();

@BeforeEach
    void init(){
    MockitoAnnotations.openMocks(this);

}
@Test
    void  testMockGetTopper(){
    when(manager.getTopper()).thenReturn("topper: Bob(273 marks)");
    String topper=manager.getTopper();
    assertEquals("topper: Bob(273 marks)",topper);
    verify(manager).getTopper();



}

//    @Test
//    void testHigestMarks()
//    {
//        when(manager.getHighestMarks()).thenReturn("A+");
//        String higest = manager.getHighestMarks();
//        assertEquals("A+", higest);
//        verify(manager).getHighestMarks();
//    }


}