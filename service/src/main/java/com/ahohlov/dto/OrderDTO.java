package com.ahohlov.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by admin on 9/9/18.
 */
public class OrderDTO {

    private Long orderId;
    private Long userId;
    private Long itemId;
    private LocalDateTime created;
    private int qauntity;
    private UserDTO userDTO;
    private ItemDTO itemDTO;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }


    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return qauntity == orderDTO.qauntity &&
                Objects.equals(orderId, orderDTO.orderId) &&
                Objects.equals(created, orderDTO.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, created, qauntity);
    }
}
