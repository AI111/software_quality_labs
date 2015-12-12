package com.softwarequalitycourse.lab2.application;


import com.softwarequalitycourse.lab2.domain.Item;

import java.util.List;

/**
 * Created by sasha on 02.10.15.
 */
public interface ApplicationService {

    List<Item> getEvenIdItems();
    List<Item> getItemsWithName(String name);


}
