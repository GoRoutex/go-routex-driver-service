package vn.com.routex.driver.service.infrastructure.persistence.adapter.booking;


import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.booking.model.Booking;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper.AuditPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.booking.entity.BookingEntityAbstract;

@UtilityClass
public class BookingPersistenceMapper {


    public Booking toDomain(BookingEntityAbstract entity) {
        if(entity == null) {
             return null;
        }

        Booking domain = Booking.builder()
                .id(entity.getId())
                .bookingCode(entity.getBookingCode())
                .routeId(entity.getRouteId())
                .customerId(entity.getCustomerId())
                .seatCount(entity.getSeatCount())
                .totalAmount(entity.getTotalAmount())
                .currency(entity.getCurrency())
                .status(entity.getStatus())
                .heldAt(entity.getHeldAt())
                .holdUntil(entity.getHoldUntil())
                .cancelledAt(entity.getCancelledAt())
                .note(entity.getNote())
                .creator(entity.getCreator())
                .build();

        AuditPersistenceMapper.toDomain(domain, entity);
        return domain;
    }


    public BookingEntityAbstract toEntity(Booking domain) {
        if(domain == null) {
            return null;
        }

        return BookingEntityAbstract.builder()
                .id(domain.getId())
                .bookingCode(domain.getBookingCode())
                .routeId(domain.getRouteId())
                .customerId(domain.getCustomerId())
                .seatCount(domain.getSeatCount())
                .totalAmount(domain.getTotalAmount())
                .currency(domain.getCurrency())
                .status(domain.getStatus())
                .heldAt(domain.getHeldAt())
                .holdUntil(domain.getHoldUntil())
                .cancelledAt(domain.getCancelledAt())
                .note(domain.getNote())
                .creator(domain.getCreator())
                .build();
    }
}
