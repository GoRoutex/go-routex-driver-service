package vn.com.routex.driver.service.application.dto.manifest;

import lombok.Builder;
import vn.com.routex.driver.service.application.dto.base.RequestContext;

import java.util.List;

@Builder
public record TripManifestView(
        RequestContext requestContext,
        List<GetTripManifestBookingView> bookingInfo,
        GetTripManifestDriverView driverInfo,
        GetTripManifestVehicleView vehicleInfo,
        GetTripManifestSummaryView summary
) {
}

