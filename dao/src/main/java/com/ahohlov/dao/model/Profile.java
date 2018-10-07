package com.ahohlov.dao.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by admin on 9/7/18.
 */


@Entity
@Table(name = "PROFILE")
public class Profile implements Serializable{

    @Id
    @GenericGenerator(
            name = "generator",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user")
    )
    @GeneratedValue(generator = "generator")
    @Column(name = "USER_ID",unique = true,nullable = false)
    private Long userId;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "TELEPHONE")
    private String telephone;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private User user;

    public Profile() {
    }


    public Profile(String address, String telephone) {
        this.address = address;
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(userId, profile.userId) &&
                Objects.equals(address, profile.address) &&
                Objects.equals(telephone, profile.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, address, telephone);
    }
}
