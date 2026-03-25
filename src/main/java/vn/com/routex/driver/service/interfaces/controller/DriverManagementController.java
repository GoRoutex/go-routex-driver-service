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
import vn.com.routex.driver.service.application.services.DriverProfileService;
import vn.com.routex.driver.service.interfaces.mapper.DriverProfileApiMapper;
import vn.com.routex.driver.service.interfaces.mapper.DriverProfileApiResponseMapper;
import vn.com.routex.driver.service.interfaces.models.driver.request.CreateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DeleteProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DriverProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateDriverStatusRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.response.CreateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.DeleteProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.DriverProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateDriverStatusResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateProfileResponse;

import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.API_PATH;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.API_VERSION;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.CREATE_PROFILE;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.DELETE_PROFILE;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.DRIVER_PREFIX;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.GET_DRIVER;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.UPDATE_PROFILE;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.UPDATE_STATUS;

@RestController
@RequestMapping(API_PATH + API_VERSION + DRIVER_PREFIX)
@RequiredArgsConstructor
public class DriverManagementController {

    private final DriverProfileService driverProfileService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        webDataBinder.setDisallowedFields("requestId", "requestDateTime", "channel", "data");
    }


    @PostMapping(CREATE_PROFILE)
    public ResponseEntity<CreateProfileResponse> updateDriverProfile(@Valid @RequestBody CreateProfileRequest request) {
        var profile = driverProfileService.create(DriverProfileApiMapper.toCommand(request));
        return ResponseEntity.ok(DriverProfileApiResponseMapper.toCreateProfileResponse(request, profile));
    }

    @PostMapping(UPDATE_PROFILE)
    public ResponseEntity<UpdateProfileResponse> updateDriverProfile(@Valid @RequestBody UpdateProfileRequest request) {
        var profile = driverProfileService.update(DriverProfileApiMapper.toCommand(request));
        return ResponseEntity.ok(DriverProfileApiResponseMapper.toUpdateProfileResponse(request, profile));
    }

    @PostMapping(DELETE_PROFILE)
    public ResponseEntity<DeleteProfileResponse> deleteDriverProfile(@Valid @RequestBody DeleteProfileRequest request) {
        var profile = driverProfileService.delete(DriverProfileApiMapper.toCommand(request));
        return ResponseEntity.ok(DriverProfileApiResponseMapper.toDeleteProfileResponse(request, profile));
    }

    @PostMapping(GET_DRIVER)
    public ResponseEntity<DriverProfileResponse> getDriverProfile(@Valid @RequestBody DriverProfileRequest request) {
        var view = driverProfileService.get(DriverProfileApiMapper.toQuery(request));
        return ResponseEntity.ok(DriverProfileApiResponseMapper.toDriverProfileResponse(request, view));
    }

    @PostMapping(UPDATE_STATUS)
    public ResponseEntity<UpdateDriverStatusResponse> updateDriverStatus(@Valid @RequestBody UpdateDriverStatusRequest request) {
        var profile = driverProfileService.updateStatus(DriverProfileApiMapper.toCommand(request));
        return ResponseEntity.ok(DriverProfileApiResponseMapper.toUpdateDriverStatusResponse(request, profile));
    }
}
