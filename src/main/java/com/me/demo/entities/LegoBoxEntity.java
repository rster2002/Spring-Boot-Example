package com.me.demo.entities;

import javax.persistence.*;

@Entity
public class LegoBoxEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToOne
    LegoSetEntity legoSetEntity;

    @ManyToOne
    private LegoStoreEntity store;

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

    public LegoSetEntity getLegoSetEntity() {
        return legoSetEntity;
    }

    public void setLegoSetEntity(LegoSetEntity legoSetEntity) {
        this.legoSetEntity = legoSetEntity;
    }

    public LegoStoreEntity getStore() {
        return store;
    }

    public void setStore(LegoStoreEntity store) {
        this.store = store;
    }
}
