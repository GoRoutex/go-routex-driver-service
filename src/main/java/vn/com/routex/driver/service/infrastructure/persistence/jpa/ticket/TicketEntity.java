package vn.com.routex.driver.service.infrastructure.persistence.jpa.ticket;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.ticket.TicketStatus;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.shared.entity.AuditingJpaEntity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "TICKET")
public class TicketEntity extends AuditingJpaEntity {

    @Id
    private String id;
    private String ticketCode;
    private String bookingId;
    private String bookingSeatId;
    private String routeId;
    private String seatNumber;
    private String customerName;
    private String customerPhone;
    private BigDecimal price;
    private TicketStatus status;
    private OffsetDateTime issuedAt;
    private OffsetDateTime checkedInAt;
    private OffsetDateTime boardedAt;
    private OffsetDateTime cancelledAt;
    private String checkedInBy;
    private String boardedBy;
    private String cancelledBy;
}
