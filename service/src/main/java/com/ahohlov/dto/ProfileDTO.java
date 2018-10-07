package com.ahohlov.dto;


import java.util.Objects;

/**
 * Created by admin on 9/7/18.
 */
public class ProfileDTO {
    private Long userId;
    private String address;
    private String telephone;
    private UserDTO userDTO;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileDTO that = (ProfileDTO) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(address, that.address) &&
                Objects.equals(telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, address, telephone);
    }
}
