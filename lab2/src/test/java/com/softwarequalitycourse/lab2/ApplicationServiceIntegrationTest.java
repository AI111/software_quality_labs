package com.softwarequalitycourse.lab2;


import com.softwarequalitycourse.lab2.application.ApplicationService;
import com.softwarequalitycourse.lab2.config.JavaConfig;
import com.softwarequalitycourse.lab2.domain.Student;
import com.softwarequalitycourse.lab2.domain.StudentRepository;
import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sasha on 10/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
public class ApplicationServiceIntegrationTest {
    private static Flyway flyway;
    @Autowired
    StudentRepository repository;
    @Autowired
    ApplicationService service;
    @BeforeClass
    public static void configInMemoryBd(){
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        DataSource dataSource = context.getBean(DataSource.class);
        flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setTargetAsString("1");
        flyway.migrate();
    }
    @Test
    public void testDeleteIdNotFib() throws Exception {
        migrateToVersion("2");
        Date date = Date.valueOf("1970-01-01");
        List<Student> ans = new ArrayList<>(Arrays.asList(new Student[]{
                new Student(0, "NAME", "LAST NAME", date, "AI111"),
                new Student(1, "NAME", "LAST NAME", date, "AI111"),
                new Student(2, "NAME", "LAST NAME", date, "AI111"),
                new Student(3, "NAME", "LAST NAME", date, "AI111"),
                new Student(5, "NAME", "LAST NAME", date, "AI111"),
                new Student(8, "NAME", "LAST NAME", date, "AI111"),
        }));


        service.deleteIdNotFib();
        assertEquals(repository.getAllStudents(),ans);
    }
    @Test
    public void testGetStudentsWithName() throws Exception {
        migrateToVersion("3");
        Date date = Date.valueOf("1970-01-01");
        List<Student> ans = new ArrayList<>(Arrays.asList(new Student[]{
                new Student(6, "ZNAME", "LAST NAME", date, "AI111"),
                new Student(9, "ZNAME", "LAST NAME", date, "AI111")
        }));



        assertEquals(service.getStudentsWithName("ZNAME"),ans);
    }
    @After
    public void releswDB(){
        flyway.clean();
    }
    private void migrateToVersion(String vers){
        flyway.setTargetAsString(vers);
        flyway.migrate();
    }
}