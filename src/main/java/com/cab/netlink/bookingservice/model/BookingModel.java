package com.cab.netlink.bookingservice.model;

import javax.persistence.*;


@Entity
@Table(name="Booking")
public class BookingModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;



    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="driver")
    private DriverModel driver ;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="customer")
    private User customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public DriverModel getDriver() {
        return driver;
    }

    public void setDriver(DriverModel driver) {
        this.driver = driver;
    }

    public User getCustomer() {

        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
