package vn.com.routex.driver.service.interfaces.controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.API_PATH;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.API_VERSION;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.DRIVER_PREFIX;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.TRIP_MANIFEST;

@RestController
@RequestMapping(API_PATH + API_VERSION + DRIVER_PREFIX)
//@PreAuthorize("hasRole('ADMIN') and hasRole('DRIVER')")
public class TripManifestController {
}
