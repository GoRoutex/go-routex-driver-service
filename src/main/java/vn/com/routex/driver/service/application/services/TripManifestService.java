package vn.com.routex.driver.service.application.services;

import vn.com.routex.driver.service.application.dto.manifest.GetTripManifestQuery;
import vn.com.routex.driver.service.application.dto.manifest.TripManifestView;

public interface TripManifestService {
    TripManifestView getTripManifest(GetTripManifestQuery query);
}
