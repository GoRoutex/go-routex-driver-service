package vn.com.routex.driver.service.interfaces.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import vn.com.routex.driver.service.application.dto.base.RequestContext;
import vn.com.routex.driver.service.application.dto.manifest.GetTripManifestQuery;
import vn.com.routex.driver.service.application.dto.manifest.TripManifestView;
import vn.com.routex.driver.service.application.services.TripManifestService;
import vn.com.routex.driver.service.interfaces.mapper.TripManifestMapper;
import vn.com.routex.driver.service.interfaces.models.base.BaseRequest;
import vn.com.routex.driver.service.interfaces.models.manifest.GetTripManifestRequest;
import vn.com.routex.driver.service.interfaces.models.manifest.GetTripManifestResponse;

import static vn.com.routex.driver.service.interfaces.controller.constant.ApiConstant.API_PATH;
import static vn.com.routex.driver.service.interfaces.controller.constant.ApiConstant.API_VERSION;
import static vn.com.routex.driver.service.interfaces.controller.constant.ApiConstant.DRIVER_PREFIX;
import static vn.com.routex.driver.service.interfaces.controller.constant.ApiConstant.TRIP_MANIFEST;

@RestController
@RequestMapping(API_PATH + API_VERSION + DRIVER_PREFIX)
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ADMIN') and hasRole('DRIVER')")
public class TripManifestController {

    private final TripManifestService tripManifestService;
    private final TripManifestMapper tripManifestMapper;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        webDataBinder.setDisallowedFields("requestId", "requestDateTime", "channel", "data");
    }

    @PostMapping(TRIP_MANIFEST)
    public ResponseEntity<GetTripManifestResponse> getTripManifest(@Valid @RequestBody GetTripManifestRequest request) {
        TripManifestView view = tripManifestService.getTripManifest(GetTripManifestQuery
                .builder()
                .context(toContext(request))
                .routeId(request.getData().getRouteId())
                .build());

        GetTripManifestResponse response = tripManifestMapper.toGetTripManifestResponse(view);

        return ResponseEntity.ok(response);
    }


    private RequestContext toContext(BaseRequest request) {
        return RequestContext.builder()
                .requestId(request.getRequestId())
                .requestDateTime(request.getRequestDateTime())
                .channel(request.getChannel())
                .build();
    }
}
