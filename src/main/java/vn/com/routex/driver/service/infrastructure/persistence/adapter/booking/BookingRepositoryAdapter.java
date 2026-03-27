package vn.com.routex.driver.service.infrastructure.persistence.adapter.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.booking.model.Booking;
import vn.com.routex.driver.service.domain.booking.port.BookingRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.booking.repository.BookingJpaRepository;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class BookingRepositoryAdapter implements BookingRepositoryPort {

    private final BookingJpaRepository bookingJpaRepository;

    @Override
    public Booking save(Booking booking) {
        return BookingPersistenceMapper.toDomain(
                bookingJpaRepository.save(
                        BookingPersistenceMapper.toEntity(booking)));
    }

    @Override
    public Optional<Booking> findById(String bookingId) {
        return bookingJpaRepository.findById(bookingId).map(BookingPersistenceMapper::toDomain);
    }

    @Override
    public String generateBookingCode() {
        return bookingJpaRepository.generateBookingCode();
    }

    @Override
    public Optional<Booking> findByRouteId(String routeId) {
        return bookingJpaRepository.findByRouteId(routeId).map(BookingPersistenceMapper::toDomain);
    }
}
