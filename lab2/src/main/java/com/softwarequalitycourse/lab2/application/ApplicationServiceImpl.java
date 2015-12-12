package com.softwarequalitycourse.lab2.application;


import com.softwarequalitycourse.lab2.domain.Item;
import com.softwarequalitycourse.lab2.domain.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sasha on 02.10.15.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ItemRepository repository;
    @Override
    @Transactional
    public List<Item> getEvenIdItems() {
        return repository.getAllItems().stream().filter(item -> item.getId()%2==0).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Item> getItemsWithName(String name) {

        return repository.getAllItems().stream().filter(student -> student.getName().equals(name)).collect(Collectors.toList());
    }


}
