package vn.com.routex.driver.service.domain.stoppoint.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.shared.model.AbstractAuditingEntity;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RouteStop extends AbstractAuditingEntity {

    private String id;

    private String routeId;

    private String stopPointId;

    private String stopOrder;

    private OffsetDateTime plannedArrivalTime;

    private OffsetDateTime plannedDepartureTime;

    private OffsetDateTime actualArrivalTime;

    private OffsetDateTime actualDepartureTime;

    private String note;
}
