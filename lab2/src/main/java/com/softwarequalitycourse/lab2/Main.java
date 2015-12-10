package com.softwarequalitycourse.lab2;


import com.softwarequalitycourse.lab2.application.ApplicationService;
import com.softwarequalitycourse.lab2.config.JavaConfig;
import com.softwarequalitycourse.lab2.domain.StudentRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sasha on 02.10.15.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        ApplicationService service = context.getBean(ApplicationService.class);
        StudentRepository repository = context.getBean(StudentRepository.class);
        System.out.println("concat _3");
//        service.concatStudentName3();
//        System.out.println(repository.getAllStudents());
//        System.out.println("repeated names");
//        System.out.println(service.getAllStudentsWithRepeatedNames());
    }
}
