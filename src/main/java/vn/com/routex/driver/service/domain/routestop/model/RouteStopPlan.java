package vn.com.routex.driver.service.domain.routestop.model;


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
public class RouteStopPlan extends AbstractAuditingEntity {
    private String id;
    private String routeId;
    private String creator;
    private int stopOrder;
    private OffsetDateTime plannedArrivalTime;
    private OffsetDateTime plannedDepartureTime;
    private String note;
    private String operationPointId;
    private String stopName;
    private String stopAddress;
    private String stopCity;
    private Double stopLatitude;
    private Double stopLongitude;
}