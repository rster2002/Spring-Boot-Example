package com.me.demo.services;

import com.me.demo.entities.LegoSetEntity;
import com.me.demo.repositories.LegoSetsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegoSetService {
    @Autowired
    LegoSetsRepo legoSetsRepo;

    public List<LegoSetEntity> getAllLegoSets() {
        return (List<LegoSetEntity>) legoSetsRepo.findAll();
    }
}
