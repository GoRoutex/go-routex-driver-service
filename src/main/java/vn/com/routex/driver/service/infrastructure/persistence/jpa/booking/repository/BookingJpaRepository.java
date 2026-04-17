package vn.com.routex.driver.service.infrastructure.persistence.jpa.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.booking.entity.BookingEntityAbstract;

import java.util.Optional;

public interface BookingJpaRepository extends JpaRepository<BookingEntityAbstract, String> {

    @Query(value = """
            SELECT generate_booking_code()
            """, nativeQuery = true)
    String generateBookingCode();

    Optional<BookingEntityAbstract> findByRouteId(String routeId);
}
