package com.cab.netlink.bookingservice.repository;

import com.cab.netlink.bookingservice.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingModel, Integer> {
}
