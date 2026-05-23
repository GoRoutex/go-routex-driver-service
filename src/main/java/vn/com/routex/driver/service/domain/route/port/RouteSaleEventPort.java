package vn.com.routex.driver.service.domain.route.port;

import vn.com.routex.driver.service.infrastructure.kafka.event.TripSellableEvent;
public interface RouteSaleEventPort {
    void publishRouteReadyForSale(
            String requestId,
            String requestDateTime,
            String channel,
            String aggregateId,
            TripSellableEvent payload
    );
}
