package vn.com.routex.driver.service.domain.assignment.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteAssignment {
    private String id;

    private String routeId;

    private String vehicleId;

    private OffsetDateTime assignedAt;

    private OffsetDateTime unAssignedAt;

    private RouteAssignmentStatus status;

}
