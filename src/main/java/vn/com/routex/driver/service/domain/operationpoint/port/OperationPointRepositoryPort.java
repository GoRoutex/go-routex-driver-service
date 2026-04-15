package vn.com.routex.driver.service.domain.operationpoint.port;

import vn.com.routex.driver.service.domain.operationpoint.model.OperationPoint;

import java.util.Optional;

/**
 * Domain repository port (no Spring Data/JPA dependency).
 */
public interface OperationPointRepositoryPort {
    Optional<OperationPoint> findById(String id);

    OperationPoint save(OperationPoint operationPoint);
}
