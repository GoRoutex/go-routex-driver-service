package vn.com.routex.driver.service.domain.route.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.routex.driver.service.domain.shared.model.AbstractAuditingEntity;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Route extends AbstractAuditingEntity {

    private String id;
    private String routeCode;

    private String origin;

    private String destination;

    private OffsetDateTime plannedStartTime;

    private OffsetDateTime plannedEndTime;

    private OffsetDateTime actualStartTime;

    private OffsetDateTime actualEndTime;

    private RouteStatus status;
}
