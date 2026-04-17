package vn.com.routex.driver.service.application.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.com.routex.driver.service.application.dto.manifest.GetTripManifestDriverView;
import vn.com.routex.driver.service.application.dto.manifest.GetTripManifestQuery;
import vn.com.routex.driver.service.application.dto.manifest.GetTripManifestSummaryView;
import vn.com.routex.driver.service.application.dto.manifest.GetTripManifestVehicleView;
import vn.com.routex.driver.service.application.dto.manifest.TripManifestView;
import vn.com.routex.driver.service.application.services.TripManifestService;
import vn.com.routex.driver.service.domain.assignment.model.RouteAssignment;
import vn.com.routex.driver.service.domain.assignment.port.RouteAssignmentRepositoryPort;
import vn.com.routex.driver.service.domain.booking.BookingSeatStatus;
import vn.com.routex.driver.service.domain.booking.model.Booking;
import vn.com.routex.driver.service.domain.booking.model.BookingSeat;
import vn.com.routex.driver.service.domain.booking.port.BookingRepositoryPort;
import vn.com.routex.driver.service.domain.booking.port.BookingSeatRepositoryPort;
import vn.com.routex.driver.service.domain.driver.model.DriverProfile;
import vn.com.routex.driver.service.domain.driver.port.DriverProfileRepositoryPort;
import vn.com.routex.driver.service.domain.route.port.RouteRepositoryPort;
import vn.com.routex.driver.service.domain.vehicle.model.Vehicle;
import vn.com.routex.driver.service.domain.vehicle.port.VehicleRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.exceptions.BusinessException;
import vn.com.routex.driver.service.infrastructure.persistence.utils.ExceptionUtils;

import java.util.List;

import static vn.com.routex.driver.service.application.services.common.ErrorConstant.BOOKING_NOT_FOUND_MESSAGE;
import static vn.com.routex.driver.service.application.services.common.ErrorConstant.DRIVER_NOT_FOUND_MESSAGE;
import static vn.com.routex.driver.service.application.services.common.ErrorConstant.RECORD_NOT_FOUND;
import static vn.com.routex.driver.service.application.services.common.ErrorConstant.ROUTE_ASSIGNMENT_NOT_FOUND;
import static vn.com.routex.driver.service.application.services.common.ErrorConstant.VEHICLE_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class TripManifestServiceImpl implements TripManifestService {

    private final RouteRepositoryPort routeRepositoryPort;
    private final BookingSeatRepositoryPort bookingSeatRepositoryPort;
    private final BookingRepositoryPort bookingRepositoryPort;
    private final DriverProfileRepositoryPort driverProfileRepositoryPort;
    private final VehicleRepositoryPort vehicleRepositoryPort;
    private final RouteAssignmentRepositoryPort routeAssignmentRepositoryPort;

    /**
     * Fetching Trip Manifest for Driver/Admins
     */

    @Override
    public TripManifestView getTripManifest(GetTripManifestQuery query) {

        RouteAssignment routeAssignment = routeAssignmentRepositoryPort.findByRouteId(query.routeId())
                .orElseThrow(() -> new BusinessException(query.context().requestId(), query.context().requestDateTime(), query.context().channel(),
                        ExceptionUtils.buildResultResponse(RECORD_NOT_FOUND, ROUTE_ASSIGNMENT_NOT_FOUND)));

        Booking booking = bookingRepositoryPort.findByRouteId(query.routeId())
                .orElseThrow(() -> new BusinessException(query.context().requestId(), query.context().requestDateTime(), query.context().channel(),
                        ExceptionUtils.buildResultResponse(RECORD_NOT_FOUND, BOOKING_NOT_FOUND_MESSAGE)));

        List<BookingSeat> bookingSeat = bookingSeatRepositoryPort.findByBookingIdAndStatus(booking.getId(), BookingSeatStatus.RESERVED);

        DriverProfile driverProfile = driverProfileRepositoryPort.findById(routeAssignment.getDriverId())
                .orElseThrow(() -> new BusinessException(query.context().requestId(), query.context().requestDateTime(), query.context().channel(),
                        ExceptionUtils.buildResultResponse(RECORD_NOT_FOUND, DRIVER_NOT_FOUND_MESSAGE)));

        Vehicle vehicle = vehicleRepositoryPort.findById(routeAssignment.getVehicleId())
                .orElseThrow(() -> new BusinessException(query.context().requestId(), query.context().requestDateTime(), query.context().channel(),
                        ExceptionUtils.buildResultResponse(RECORD_NOT_FOUND, VEHICLE_NOT_FOUND_MESSAGE)));



        int bookedSeats = bookingSeat.size();

        return TripManifestView.builder()
                .driverInfo(GetTripManifestDriverView.builder()
                        .driverId(driverProfile.getId())
                        .phoneNumber(driverProfile.getPhoneNumber())
                        .fullName(driverProfile.getFullName())
                        .build())
                .vehicleInfo(GetTripManifestVehicleView.builder()
                        .vehicleId(vehicle.getId())
                        .vehicleType(vehicle.getType().name())
                        .plate(vehicle.getVehiclePlate())
                        .totalSeats(vehicle.getSeatCapacity())
                        .build())
                .summary(GetTripManifestSummaryView.builder()
                        .totalSeats(vehicle.getSeatCapacity())
                        .bookedSeats(bookingSeat.size())
                        .checkedInSeats(1)
                        .boardedSeats(1)
                        .cancelledSeats(1)
                        .availableSeats(1)
                        .build())
                .build();
    }
}
