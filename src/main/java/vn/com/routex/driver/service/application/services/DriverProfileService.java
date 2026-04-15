package vn.com.routex.driver.service.application.services;

import vn.com.routex.driver.service.application.dto.driver.CreateDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.CreateDriverProfileResult;
import vn.com.routex.driver.service.application.dto.driver.DeleteDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.DeleteDriverProfileResult;
import vn.com.routex.driver.service.application.dto.driver.DriverProfileDetailsView;
import vn.com.routex.driver.service.application.dto.driver.GetDriverProfileQuery;
import vn.com.routex.driver.service.application.dto.driver.UpdateDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.UpdateDriverProfileResult;
import vn.com.routex.driver.service.application.dto.driver.UpdateDriverStatusCommand;
import vn.com.routex.driver.service.application.dto.driver.UpdateDriverStatusResult;

public interface DriverProfileService {
    CreateDriverProfileResult create(CreateDriverProfileCommand command);
    UpdateDriverProfileResult update(UpdateDriverProfileCommand command);
    DeleteDriverProfileResult delete(DeleteDriverProfileCommand command);
    UpdateDriverStatusResult updateStatus(UpdateDriverStatusCommand command);
    DriverProfileDetailsView get(GetDriverProfileQuery query);
}
