package com.softwarequalitycourse.lab2.application;

import com.softwarequalitycourse.lab2.application.ApplicationServiceImpl;
import com.softwarequalitycourse.lab2.domain.Student;
import com.softwarequalitycourse.lab2.domain.StudentRepository;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by sasha on 10/2/15.
 */
public class ApplicationServiceUnitTest {

    @Test
    public void testFibonachiList() throws Exception {
        List<Integer> req = new ArrayList<>(Arrays.asList(new Integer[]{0, 1, 1, 2, 3, 5, 8, 13}));
        List<Integer> ans = new ApplicationServiceImpl().fibonachiList(11);

        assertEquals(req, ans);

    }

    @Test
    public void testDeleteIdNotFib() throws Exception {
        Date date = Date.valueOf("1970-01-01");
        List<Student> list = new ArrayList<>(Arrays.asList(new Student[]{
                new Student(0, "NAME", "LAST NAME", date, "AI11"),
                new Student(1, "NAME", "LAST NAME", date, "AI11"),
                new Student(2, "NAME", "LAST NAME", date, "AI11"),
                new Student(3, "NAME", "LAST NAME", date, "AI11"),
                new Student(4, "NAME", "LAST NAME", date, "AI11"),
                new Student(5, "NAME", "LAST NAME", date, "AI11"),
                new Student(6, "NAME", "LAST NAME", date, "AI11"),
                new Student(7, "NAME", "LAST NAME", date, "AI11"),
                new Student(8, "NAME", "LAST NAME", date, "AI11"),
                new Student(9, "NAME", "LAST NAME", date, "AI11"),

        }));


        StudentRepository mockRepository = mock(StudentRepository.class);
        ApplicationServiceImpl applicationService = new ApplicationServiceImpl();
        applicationService.repository = mockRepository;
        when(mockRepository.getAllStudents()).thenReturn(list);
        applicationService.deleteIdNotFib();
        verify(mockRepository, times(1)).getAllStudents();

        verify(mockRepository).removeStudent(new Student(4, "NAME", "LAST NAME", date, "AI11"));
        verify(mockRepository).removeStudent(new Student(6, "NAME", "LAST NAME", date, "AI11"));
        verify(mockRepository).removeStudent(new Student(7, "NAME", "LAST NAME", date, "AI11"));
        verify(mockRepository).removeStudent(new Student(9, "NAME", "LAST NAME", date, "AI11"));
    }

    @Test
    public void testDeleteIdNotFibNoData() throws Exception {
        Date date = Date.valueOf("1970-01-01");
        List<Student> list = new ArrayList<>();

        StudentRepository mockRepository = mock(StudentRepository.class);
        ApplicationServiceImpl applicationService = new ApplicationServiceImpl();
        applicationService.repository = mockRepository;
        when(mockRepository.getAllStudents()).thenReturn(list);
        applicationService.deleteIdNotFib();
        verify(mockRepository, times(1)).getAllStudents();
        verify(mockRepository, never()).removeStudent(any(Student.class));

    }

    @Test
    public void testGetStudentsWithName() throws Exception {
        Date date = Date.valueOf("1970-01-01");
        List<Student> list = new ArrayList<>(Arrays.asList(new Student[]{
                new Student(0, "AAME", "LAST NAME", date, "AI11"),
                new Student(1, "NAME", "LAST NAME", date, "AI11"),
                new Student(2, "NAME", "LAST NAME", date, "AI11"),
                new Student(3, "NAME", "LAST NAME", date, "AI11"),
                new Student(4, "NAME", "LAST NAME", date, "AI11"),
                new Student(5, "NAME", "LAST NAME", date, "AI11"),
                new Student(6, "NAME", "LAST NAME", date, "AI11"),
                new Student(7, "AAME", "LAST NAME", date, "AI11"),
                new Student(8, "NAME", "LAST NAME", date, "AI11"),
                new Student(9, "NAME", "LAST NAME", date, "AI11"),

        }));
        List<Student> req = new ArrayList<>(Arrays.asList(new Student[]{
                new Student(0, "AAME", "LAST NAME", date, "AI11"),
                new Student(7, "AAME", "LAST NAME", date, "AI11")

        }));


        StudentRepository mockRepository = mock(StudentRepository.class);
        ApplicationServiceImpl applicationService = new ApplicationServiceImpl();
        applicationService.repository = mockRepository;
        when(mockRepository.getAllStudents()).thenReturn(list);
        List<Student> ans = applicationService.getStudentsWithName("AAME");
        assertEquals(ans,req);

    }
    @Test
    public void testGetStudentsWithNameNoMaches() throws Exception {
        Date date = Date.valueOf("1970-01-01");
        List<Student> list = new ArrayList<>(Arrays.asList(new Student[]{
                new Student(0, "AAME", "LAST NAME", date, "AI11"),
                new Student(1, "NAME", "LAST NAME", date, "AI11"),
                new Student(2, "NAME", "LAST NAME", date, "AI11"),
                new Student(3, "NAME", "LAST NAME", date, "AI11"),
                new Student(4, "NAME", "LAST NAME", date, "AI11"),
                new Student(5, "NAME", "LAST NAME", date, "AI11"),
                new Student(6, "NAME", "LAST NAME", date, "AI11"),
                new Student(7, "AAME", "LAST NAME", date, "AI11"),
                new Student(8, "NAME", "LAST NAME", date, "AI11"),
                new Student(9, "NAME", "LAST NAME", date, "AI11"),

        }));
        List<Student> req = new ArrayList<>();
        StudentRepository mockRepository = mock(StudentRepository.class);
        ApplicationServiceImpl applicationService = new ApplicationServiceImpl();
        applicationService.repository = mockRepository;
        when(mockRepository.getAllStudents()).thenReturn(list);
        List<Student> ans = applicationService.getStudentsWithName("MAAME");
        assertEquals(ans,req);

    }
}