package vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.operationpoint.model.OperationPoint;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper.AuditPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.entity.OperationPointEntity;

@UtilityClass
public class StopPointPersistenceMapper {
    public OperationPoint toDomain(OperationPointEntity operationPointEntity) {
        if (operationPointEntity == null) {
            return null;
        }
        OperationPoint domain = OperationPoint.builder()
                .id(operationPointEntity.getId())
                .merchantId(operationPointEntity.getMerchantId())
                .code(operationPointEntity.getCode())
                .name(operationPointEntity.getName())
                .type(operationPointEntity.getType())
                .address(operationPointEntity.getAddress())
                .city(operationPointEntity.getCity())
                .latitude(operationPointEntity.getLatitude())
                .longitude(operationPointEntity.getLongitude())
                .status(operationPointEntity.getStatus())
                .build();

        AuditPersistenceMapper.toDomain(domain, operationPointEntity);
        return domain;
    }

    public OperationPointEntity toEntity(OperationPoint operationPoint) {
        if (operationPoint == null) {
            return null;
        }
        return OperationPointEntity.builder()
                .id(operationPoint.getId())
                .merchantId(operationPoint.getMerchantId())
                .code(operationPoint.getCode())
                .name(operationPoint.getName())
                .type(operationPoint.getType())
                .address(operationPoint.getAddress())
                .city(operationPoint.getCity())
                .latitude(operationPoint.getLatitude())
                .longitude(operationPoint.getLongitude())
                .status(operationPoint.getStatus())
                .createdAt(operationPoint.getCreatedAt())
                .createdBy(operationPoint.getCreatedBy())
                .updatedAt(operationPoint.getUpdatedAt())
                .updatedBy(operationPoint.getUpdatedBy())
                .build();
    }
}
