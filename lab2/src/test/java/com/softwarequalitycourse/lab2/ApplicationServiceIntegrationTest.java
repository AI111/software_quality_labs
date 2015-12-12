package com.softwarequalitycourse.lab2;


import com.softwarequalitycourse.lab2.application.ApplicationService;
import com.softwarequalitycourse.lab2.config.JavaConfig;
import com.softwarequalitycourse.lab2.domain.Item;
import com.softwarequalitycourse.lab2.domain.ItemRepository;
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
    ItemRepository repository;
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
    public void testGetEvenIdItems() throws Exception {
        migrateToVersion("2");

        List<Item> req = new ArrayList<>(Arrays.asList(new Item[]{
                new Item(0, "name", "description",0.99),
                new Item(2, "name", "description",0.99),
                new Item(4, "name", "description",0.99),
                new Item(6, "name", "description",0.99),
                new Item(8, "name", "description",0.99)
        }));

        assertEquals(service.getEvenIdItems(),req);
    }
    @Test
    public void testGetItemsWithName() throws Exception {
        migrateToVersion("3");
        List<Item> ans = new ArrayList<>(Arrays.asList(new Item[]{
                new Item(6, "name", "description",0.99),
                new Item(9, "name", "description",0.99)
        }));



        assertEquals(service.getItemsWithName("name"),ans);
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