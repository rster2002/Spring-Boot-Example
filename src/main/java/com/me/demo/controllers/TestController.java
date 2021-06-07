package com.me.demo.controllers;

import com.me.demo.DTOs.LegoSetDTO;
import com.me.demo.entities.LegoSetEntity;
import com.me.demo.services.LegoSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class TestController {
    @Autowired
    LegoSetService legoSetService;

    @RequestMapping(value = "/sets", method = RequestMethod.GET)
    public List<LegoSetDTO> sets() {
        List<LegoSetEntity> entities = legoSetService.getAllLegoSets();

        return entities.stream()
                .map(set -> LegoSetDTO.fromEntity(set))
                .collect(Collectors.toList());
    }
}
