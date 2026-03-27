package vn.com.routex.driver.service.domain.booking.port;

import vn.com.routex.driver.service.domain.booking.model.Booking;

import java.util.Optional;

public interface BookingRepositoryPort {
    Booking save(Booking booking);

    Optional<Booking> findById(String bookingId);

    String generateBookingCode();

    Optional<Booking> findByRouteId(String routeId);
}
