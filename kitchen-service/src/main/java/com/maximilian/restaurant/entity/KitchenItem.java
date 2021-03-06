package com.maximilian.restaurant.entity;

import com.maximilian.restaurant.response.kitchen.KitchenItemResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "kitchen_items_r")
public class KitchenItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kitchen_item_id", nullable = false, unique = true)
    private Long id;

    @Column
    @NotNull
    private String name;

    // not best implementation of cost of some menu item
    @Column
    @NotNull
    @Positive
    private BigDecimal cost;

    public KitchenItemResponse toResponse() {
        KitchenItemResponse resp = new KitchenItemResponse();
        resp.setId(id);
        resp.setName(name);
        resp.setCost(cost);
        return resp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
