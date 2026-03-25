package vn.com.routex.driver.service.application.dto.driver;

import vn.com.routex.driver.service.domain.driver.model.DriverProfile;
import vn.com.routex.driver.service.domain.user.model.User;

public record DriverProfileDetailsView(DriverProfile profile, User user) {
}
