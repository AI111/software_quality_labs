package com.softwarequalitycourse.lab2.application;

import com.softwarequalitycourse.lab2.domain.Item;
import com.softwarequalitycourse.lab2.domain.ItemRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by sasha on 10/2/15.
 */
public class ApplicationServiceUnitTest {

    @Test
    public void testGetEvenIdItems() throws Exception {
        List<Item> list = new ArrayList<>(Arrays.asList(new Item[]{
                new Item(0, "AAME", "description",0.99),
                new Item(1, "NAME", "description",0.99),
                new Item(2, "NAME", "description",0.99),
                new Item(3, "NAME", "description",0.99),
                new Item(4, "NAME", "description",0.99),
                new Item(5, "NAME", "description",0.99),
                new Item(6, "NAME", "description",0.99),
                new Item(7, "AAME", "description",0.99),
                new Item(8, "NAME", "description",0.99),
                new Item(9, "NAME", "description",0.99),

        }));
        List<Item> req = new ArrayList<>(Arrays.asList(new Item[]{
                new Item(0, "AAME", "description",0.99),
                new Item(2, "NAME", "description",0.99),
                new Item(4, "NAME", "description",0.99),
                new Item(6, "NAME", "description",0.99),
                new Item(8, "NAME", "description",0.99)
        }));


        ItemRepository mockRepository = mock(ItemRepository.class);
        ApplicationServiceImpl applicationService = new ApplicationServiceImpl();
        applicationService.repository = mockRepository;
        when(mockRepository.getAllItems()).thenReturn(list);
        List<Item> ans = applicationService.getEvenIdItems();
        assertEquals(ans,req);
    }
    @Test
    public void testGetEvenIdItemsNoMatches() throws Exception {
            List<Item> list = new ArrayList<>(Arrays.asList(new Item[]{
                    new Item(19, "AAME", "description",0.99),
                    new Item(1, "NAME", "description",0.99),
                    new Item(17, "NAME", "description",0.99),
                    new Item(3, "NAME", "description",0.99),
                    new Item(15, "NAME", "description",0.99),
                    new Item(5, "NAME", "description",0.99),
                    new Item(13, "NAME", "description",0.99),
                    new Item(7, "AAME", "description",0.99),
                    new Item(11, "NAME", "description",0.99),
                    new Item(9, "NAME", "description",0.99),

            }));
            List<Item> req = new ArrayList<>();

            ItemRepository mockRepository = mock(ItemRepository.class);
            ApplicationServiceImpl applicationService = new ApplicationServiceImpl();
            applicationService.repository = mockRepository;
            when(mockRepository.getAllItems()).thenReturn(list);
            List<Item> ans = applicationService.getEvenIdItems();
            assertEquals(ans,req);
        }
    

    @Test
    public void testGetItemsWithName() throws Exception {
        List<Item> list = new ArrayList<>(Arrays.asList(new Item[]{
                new Item(0, "AAME", "description",0.99),
                new Item(1, "NAME", "description",0.99),
                new Item(2, "NAME", "description",0.99),
                new Item(3, "NAME", "description",0.99),
                new Item(4, "NAME", "description",0.99),
                new Item(5, "NAME", "description",0.99),
                new Item(6, "NAME", "description",0.99),
                new Item(7, "AAME", "description",0.99),
                new Item(8, "NAME", "description",0.99),
                new Item(9, "NAME", "description",0.99),

        }));
        List<Item> req = new ArrayList<>(Arrays.asList(new Item[]{
                new Item(0, "AAME", "description",0.99),
                new Item(7, "AAME", "description",0.99)

        }));


        ItemRepository mockRepository = mock(ItemRepository.class);
        ApplicationServiceImpl applicationService = new ApplicationServiceImpl();
        applicationService.repository = mockRepository;
        when(mockRepository.getAllItems()).thenReturn(list);
        List<Item> ans = applicationService.getItemsWithName("AAME");
        assertEquals(ans,req);

    }
    @Test
    public void testGetItemsWithNameNoMaches() throws Exception {
        List<Item> list = new ArrayList<>(Arrays.asList(new Item[]{
                new Item(0, "AAME", "description",0.99),
                new Item(1, "NAME", "description",0.99),
                new Item(2, "NAME", "description",0.99),
                new Item(3, "NAME", "description",0.99),
                new Item(4, "NAME", "description",0.99),
                new Item(5, "NAME", "description",0.99),
                new Item(6, "NAME", "description",0.99),
                new Item(7, "AAME", "description",0.99),
                new Item(8, "NAME", "description",0.99),
                new Item(9, "NAME", "description",0.99),

        }));
        List<Item> req = new ArrayList<>();
        ItemRepository mockRepository = mock(ItemRepository.class);
        ApplicationServiceImpl applicationService = new ApplicationServiceImpl();
        applicationService.repository = mockRepository;
        when(mockRepository.getAllItems()).thenReturn(list);
        List<Item> ans = applicationService.getItemsWithName("MAAME");
        assertEquals(ans,req);

    }
}