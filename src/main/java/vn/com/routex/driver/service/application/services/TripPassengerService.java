package vn.com.routex.driver.service.application.services;

import vn.com.routex.driver.service.application.dto.passengers.PassengerCheckinCommand;
import vn.com.routex.driver.service.application.dto.passengers.PassengerCheckinResult;

public interface TripPassengerService {
    PassengerCheckinResult checkInAction(PassengerCheckinCommand command);
}
