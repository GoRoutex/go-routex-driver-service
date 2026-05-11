package vn.com.routex.driver.service.domain.route.port;



public interface RouteSaleEventPort {
    void publishRouteReadyForSale(
            String requestId,
            String requestDateTime,
            String channel,
            String aggregateId,
            TripSellableEvent payload
    );
}
