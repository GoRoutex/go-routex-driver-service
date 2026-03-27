package vn.com.routex.driver.service.application.services;

import vn.com.routex.driver.service.application.dto.driver.CreateDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.DeleteDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.DriverProfileDetailsView;
import vn.com.routex.driver.service.application.dto.driver.GetDriverProfileQuery;
import vn.com.routex.driver.service.application.dto.driver.UpdateDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.UpdateDriverStatusCommand;
import vn.com.routex.driver.service.domain.driver.model.DriverProfile;

public interface DriverProfileService {
    DriverProfile create(CreateDriverProfileCommand command);
    DriverProfile update(UpdateDriverProfileCommand command);
    DriverProfile delete(DeleteDriverProfileCommand command);
    DriverProfile updateStatus(UpdateDriverStatusCommand command);
    DriverProfileDetailsView get(GetDriverProfileQuery query);
}
