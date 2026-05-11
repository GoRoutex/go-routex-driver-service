package vn.com.routex.driver.service.domain.route.port;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RouteStopRepositoryPort {
    void saveAll(List<RouteStopPlan> stopPlans);

    void save(RouteStopPlan routeStopPlan);

    List<RouteStopPlan> findByRouteId(String routeId);

    Map<String, List<RouteStopPlan>> findByRouteIds(List<String> routeIds);

    Optional<RouteStopPlan> findByRouteIdAndStopOrder(String routeId, String stopOrder);
}

