package vn.com.routex.driver.service.infrastructure.persistence.jpa.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.routex.driver.service.domain.booking.BookingSeatStatus;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.booking.entity.BookingSeatEntityAbstract;

import java.util.List;

public interface BookingSeatJpaRepository extends JpaRepository<BookingSeatEntityAbstract, String> {
    List<BookingSeatEntityAbstract> findByBookingId(String bookingId);
    List<BookingSeatEntityAbstract> findByBookingIdAndStatus(String id, BookingSeatStatus bookingSeatStatus);
}
