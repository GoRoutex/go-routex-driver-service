package vn.com.routex.driver.service.infrastructure.persistence.jpa.route.projection;

public interface RouteSeatAvailabilityProjection {

    String getRouteId();

    Long getAvailableSeat();
}

