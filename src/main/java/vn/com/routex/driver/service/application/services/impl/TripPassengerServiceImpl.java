package vn.com.routex.driver.service.application.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.com.routex.driver.service.application.dto.passengers.PassengerCheckinCommand;
import vn.com.routex.driver.service.application.dto.passengers.PassengerCheckinResult;
import vn.com.routex.driver.service.application.services.TripPassengerService;
import vn.com.routex.driver.service.domain.booking.port.BookingRepositoryPort;
import vn.com.routex.driver.service.domain.booking.port.BookingSeatRepositoryPort;


@RequiredArgsConstructor
@Service
public class TripPassengerServiceImpl implements TripPassengerService {


    private final BookingSeatRepositoryPort bookingSeatRepositoryPort;
    private final BookingRepositoryPort bookingRepositoryPort;

    @Override
    public PassengerCheckinResult checkInAction(PassengerCheckinCommand command) {
        return null;
    }
}
