package com.me.demo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class LegoStoreEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "store")
    private Set<LegoBoxEntity> boxes = new HashSet<>();

    @ManyToMany
    private Set<LegoWarehouseEntity> providers = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<LegoBoxEntity> getBoxes() {
        return boxes;
    }

    public void setBoxes(Set<LegoBoxEntity> boxes) {
        this.boxes = boxes;
    }

    public Set<LegoWarehouseEntity> getProviders() {
        return providers;
    }

    public void setProviders(Set<LegoWarehouseEntity> providers) {
        this.providers = providers;
    }
}
