package vn.com.routex.driver.service.domain.booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.routex.driver.service.domain.booking.BookingSeatStatus;
import vn.com.routex.driver.service.domain.shared.model.AbstractAuditingEntity;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingSeat extends AbstractAuditingEntity {
    private String id;
    private String bookingId;
    private String routeId;
    private String seatNo;
    private BigDecimal price;
    private BookingSeatStatus status;
    private String creator;
}
