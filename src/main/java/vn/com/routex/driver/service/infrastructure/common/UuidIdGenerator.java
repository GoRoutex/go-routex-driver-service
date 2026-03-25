package vn.com.routex.driver.service.infrastructure.common;

import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.shared.port.IdGeneratorPort;

import java.util.UUID;

@Component
 public class UuidIdGenerator implements IdGeneratorPort {
    @Override
    public String newId() {
        return UUID.randomUUID().toString();
    }
}
