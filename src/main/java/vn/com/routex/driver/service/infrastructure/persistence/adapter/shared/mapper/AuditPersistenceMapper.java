package vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.shared.entity.AbstractAuditingEntity;

@UtilityClass
public class AuditPersistenceMapper {
    public void toDomain(vn.com.routex.driver.service.domain.shared.model.AbstractAuditingEntity domain, AbstractAuditingEntity entity) {
        if (domain == null || entity == null) {
            return;
        }
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setCreatedBy(entity.getCreatedBy());
        domain.setUpdatedBy(entity.getUpdatedBy());
        domain.setUpdatedAt(entity.getUpdatedAt());
    }

    public void toEntity(AbstractAuditingEntity entity, vn.com.routex.driver.service.domain.shared.model.AbstractAuditingEntity domain) {
        if (entity == null || domain == null) {
            return;
        }
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setCreatedBy(domain.getCreatedBy());
        entity.setUpdatedBy(domain.getUpdatedBy());
        entity.setUpdatedAt(domain.getUpdatedAt());
    }
}
