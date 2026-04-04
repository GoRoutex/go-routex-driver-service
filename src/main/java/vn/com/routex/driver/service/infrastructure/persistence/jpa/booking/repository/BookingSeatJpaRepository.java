package vn.com.routex.driver.service.infrastructure.persistence.jpa.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.routex.driver.service.domain.booking.BookingSeatStatus;
import vn.com.routex.driver.service.domain.booking.model.BookingSeat;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.booking.entity.BookingSeatJpaEntity;

import java.util.List;
import java.util.Optional;

public interface BookingSeatJpaRepository extends JpaRepository<BookingSeatJpaEntity, String> {
    List<BookingSeatJpaEntity> findByBookingId(String bookingId);
    List<BookingSeatJpaEntity> findByBookingIdAndStatus(String id, BookingSeatStatus bookingSeatStatus);
}
