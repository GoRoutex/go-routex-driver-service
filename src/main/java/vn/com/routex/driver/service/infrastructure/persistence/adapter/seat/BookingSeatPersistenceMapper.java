package vn.com.routex.driver.service.infrastructure.persistence.adapter.seat;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.booking.model.BookingSeat;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper.AuditPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.booking.entity.BookingSeatEntityAbstract;

import java.util.List;

@UtilityClass
public class BookingSeatPersistenceMapper {
    public BookingSeat toDomain(BookingSeatEntityAbstract entity) {
        if(entity == null) {
            return null;
        }
        BookingSeat domain = BookingSeat.builder()
                .id(entity.getId())
                .bookingId(entity.getBookingId())
                .routeId(entity.getRouteId())
                .seatNo(entity.getSeatNo())
                .price(entity.getPrice())
                .status(entity.getStatus())
                .creator(entity.getCreator())
                .build();

        AuditPersistenceMapper.toDomain(domain, entity);
        return domain;
    }



    public List<BookingSeat> toListDomain(List<BookingSeatEntityAbstract> entities) {
        if(entities == null) {
             return null;
        }

        return entities.stream()
                .map(BookingSeatPersistenceMapper::toDomain)
                .toList();
    }

    public List<BookingSeatEntityAbstract> toListEntity(List<BookingSeat> domainList) {
        if(domainList == null) {
             return null;
        }
        return domainList.stream()
                .map(BookingSeatPersistenceMapper::toEntity)
                .toList();
    }

    public BookingSeatEntityAbstract toEntity(BookingSeat domain) {
        if(domain == null) {
            return null;
        }

        return BookingSeatEntityAbstract.builder()
                .id(domain.getId())
                .bookingId(domain.getBookingId())
                .routeId(domain.getRouteId())
                .seatNo(domain.getSeatNo())
                .price(domain.getPrice())
                .status(domain.getStatus())
                .creator(domain.getCreator())
                .build();
    }
}
