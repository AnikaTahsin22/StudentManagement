package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentManagerTest {

    @Mock
    private Student student1;

    @Mock
    private Student student2;

    @InjectMocks
    private StudentManager manager;

    @BeforeEach
    void setUp() {

        manager.getAllStudents().add(student1);
        manager.getAllStudents().add(student2);

        when(student1.totalMarks()).thenReturn(250);
        when(student2.totalMarks()).thenReturn(200);
        when(student1.getName()).thenReturn("Rubayet");
    }

    @Test
     void testGetTopper() {
        String result = manager.getTopper();

        assertEquals("Topper: Rubayet (250 marks)", result);
        verify(student1, times(4)).totalMarks();
        verify(student2).totalMarks();
        verify(student1).getName();
    }
}