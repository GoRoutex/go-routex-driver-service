package vn.com.routex.driver.service.domain.route.port;

import vn.com.routex.driver.service.domain.route.model.ProvincesInformationPair;

public interface RouteProvincesLookupPort {
    ProvincesInformationPair getCodes(String origin, String destination);
}
