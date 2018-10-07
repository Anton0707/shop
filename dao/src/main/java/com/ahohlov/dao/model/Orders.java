package com.ahohlov.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by admin on 9/9/18.
 */
@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID",updatable = false,nullable = false)
    private Long orderId;
    @Column(name = "ITEM_ID")
    private Long itemId;
    @Column(name = "CREATED")
    private LocalDateTime created;
    @Column(name = "QUANTITY")
    private int qauntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    public Orders(){}

    public Orders(LocalDateTime created, Long item_id, int qauntity, User user) {
        this.created = created;
        this.itemId = item_id;
        this.qauntity = qauntity;
        this.user = user;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return qauntity == orders.qauntity &&
                Objects.equals(orderId, orders.orderId) &&
                Objects.equals(created, orders.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, created, qauntity);
    }
}
