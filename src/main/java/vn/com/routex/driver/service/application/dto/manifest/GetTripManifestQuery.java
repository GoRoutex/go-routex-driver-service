package vn.com.routex.driver.service.application.dto.manifest;

import lombok.Builder;
import vn.com.routex.driver.service.application.dto.base.RequestContext;

@Builder
public record GetTripManifestQuery(
        RequestContext context,
        String routeId) {
}

