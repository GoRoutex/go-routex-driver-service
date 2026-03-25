package vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.stoppoint.model.StopPoint;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper.AuditPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.entity.StopPointJpaEntity;

@UtilityClass
public class StopPointPersistenceMapper {
    public StopPoint toDomain(StopPointJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        StopPoint domain = StopPoint.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .latitude(entity.getLatitude())
                .longtitude(entity.getLongtitude())
                .type(entity.getType())
                .build();
        AuditPersistenceMapper.toDomain(domain, entity);
        return domain;
    }

    public StopPointJpaEntity toEntity(StopPoint domain) {
        if (domain == null) {
            return null;
        }
        StopPointJpaEntity entity = StopPointJpaEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .address(domain.getAddress())
                .latitude(domain.getLatitude())
                .longtitude(domain.getLongtitude())
                .type(domain.getType())
                .build();
        return entity;
    }
}
