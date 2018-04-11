package com.cab.netlink.bookingservice.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @Column(name="userName")
    private String userName ;

    @Column(name ="firstName")
    private String firstName ;

    @Column(name="lastName")
    private String lastName;


    @Column(name="user_latitude")
    private BigDecimal user_latitude ;

    @Column(name="user_longitude")
    private BigDecimal user_longitude ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public BigDecimal getUser_latitude() {
        return user_latitude;
    }

    public void setUser_latitude(BigDecimal user_latitude) {
        this.user_latitude = user_latitude;
    }

    public BigDecimal getUser_longitude() {
        return user_longitude;
    }

    public void setUser_longitude(BigDecimal user_longitude) {
        this.user_longitude = user_longitude;
    }




}
