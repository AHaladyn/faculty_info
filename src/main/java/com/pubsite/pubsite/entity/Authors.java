package com.pubsite.pubsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "authors")
public class Authors implements Serializable {

    private static final long serialVersionUID = 1091206033011680056L;
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "first_name")
    @NotNull
    private String firstName;
    @Column(name = "last_name")
    @NotNull
    private String lastName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
