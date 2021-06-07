package com.me.demo.DTOs;

import com.me.demo.entities.LegoSetEntity;

public class LegoSetDTO {
    private Integer id;
    private String name;
    private Integer numberOfParts;
    private Integer minimumAge;

    public LegoSetDTO(Integer id, String name, Integer numberOfParts, Integer minimumAge) {
        this.id = id;
        this.name = name;
        this.numberOfParts = numberOfParts;
        this.minimumAge = minimumAge;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfParts() {
        return numberOfParts;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public static LegoSetDTO fromEntity(LegoSetEntity entity) {
        return new LegoSetDTO(
                entity.getId(),
                entity.getName(),
                entity.getNumberOfParts(),
                entity.getMinimumAge()
        );
    }
}
