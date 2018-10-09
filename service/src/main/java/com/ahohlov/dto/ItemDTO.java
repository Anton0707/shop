package com.ahohlov.dto;

import com.ahohlov.dao.model.Orders;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by admin on 10/9/18.
 */
public class ItemDTO {
    private Long itemId;
    private String name;
    private String description;
    private String uniqueNumber;
    private BigDecimal price;
    private OrderDTO orderDTO;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(itemId, itemDTO.itemId) &&
                Objects.equals(name, itemDTO.name) &&
                Objects.equals(description, itemDTO.description) &&
                Objects.equals(uniqueNumber, itemDTO.uniqueNumber) &&
                Objects.equals(price, itemDTO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, description, uniqueNumber, price);
    }
}
