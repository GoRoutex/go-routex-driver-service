package vn.com.routex.driver.service.infrastructure.persistence.adapter.seat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.booking.BookingSeatStatus;
import vn.com.routex.driver.service.domain.booking.model.BookingSeat;
import vn.com.routex.driver.service.domain.booking.port.BookingSeatRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.booking.repository.BookingSeatJpaRepository;

import java.util.List;


@RequiredArgsConstructor
@Component
public class BookingSeatRepositoryAdapter implements BookingSeatRepositoryPort {

    private final BookingSeatJpaRepository bookingSeatJpaRepository;

    @Override
    public List<BookingSeat> saveAll(List<BookingSeat> bookingSeats) {

        return BookingSeatPersistenceMapper
                .toListDomain(bookingSeatJpaRepository
                        .saveAll(BookingSeatPersistenceMapper
                                .toListEntity(bookingSeats)));

    }

    @Override
    public BookingSeat save(BookingSeat bookingSeat) {
        return BookingSeatPersistenceMapper.toDomain(
                bookingSeatJpaRepository.save(BookingSeatPersistenceMapper.toEntity(bookingSeat)));
    }

    @Override
    public List<BookingSeat> findByBookingId(String bookingId) {
        return bookingSeatJpaRepository.findByBookingId(bookingId).stream().map(BookingSeatPersistenceMapper::toDomain).toList();

    }

    @Override
    public List<BookingSeat> findByBookingIdAndStatus(String id, BookingSeatStatus bookingSeatStatus) {
        return bookingSeatJpaRepository.findByBookingIdAndStatus(id, bookingSeatStatus).stream().map(BookingSeatPersistenceMapper::toDomain).toList();

    }
}
