package vn.com.routex.driver.service.domain.booking.port;

import vn.com.routex.driver.service.domain.booking.model.BookingSeat;

import java.util.List;
import java.util.Optional;

public interface BookingSeatRepositoryPort {
    List<BookingSeat> saveAll(List<BookingSeat> bookingSeats);

    BookingSeat save(BookingSeat bookingSeat);

    List<BookingSeat> findByBookingId(String bookingId);
}
