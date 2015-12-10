package com.softwarequalitycourse.lab2.application;


import com.softwarequalitycourse.lab2.domain.Student;
import com.softwarequalitycourse.lab2.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * Created by sasha on 02.10.15.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    StudentRepository repository;


    List fibonachiList(int n){
        LinkedList<Integer> ans = new LinkedList(Arrays.asList(new Integer[]{0,1,1}));
        int a = 1, b = 1;
        int fib = 2;
        while (n > fib) {
            fib = a + b;
            a = b;
            b = fib;
            ans.add(fib);
        }
        return ans;
    }
    @Transactional
    @Override
    public void deleteIdNotFib() {
        List<Student> students = repository.getAllStudents();
        if(students.size()>0) {
            int max = Collections.max(students, (o1, o2) -> o1.getId() - o2.getId()).getId();
            List<Integer> fib = fibonachiList(max);
            students.stream().filter(student -> Collections.binarySearch(fib, student.getId()) < 0)
                    .forEach(student1 -> repository.removeStudent(student1));
        }
    }

    @Transactional
    @Override
    public List<Student> getStudentsWithName(String name) {

        return repository.getAllStudents().stream().filter(student -> student.getName().equals(name)).collect(Collectors.toList());
    }
}
