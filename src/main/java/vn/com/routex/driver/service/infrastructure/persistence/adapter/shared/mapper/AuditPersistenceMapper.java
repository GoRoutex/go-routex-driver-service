package vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.shared.model.AbstractAuditingEntity;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.shared.entity.AuditingJpaEntity;

@UtilityClass
public class AuditPersistenceMapper {
    public void toDomain(AbstractAuditingEntity domain, AuditingJpaEntity entity) {
        if (domain == null || entity == null) {
            return;
        }
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setCreatedBy(entity.getCreatedBy());
        domain.setUpdatedBy(entity.getUpdatedBy());
        domain.setUpdatedAt(entity.getUpdatedAt());
    }

    public void toEntity(AuditingJpaEntity entity, AbstractAuditingEntity domain) {
        if (entity == null || domain == null) {
            return;
        }
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setCreatedBy(domain.getCreatedBy());
        entity.setUpdatedBy(domain.getUpdatedBy());
        entity.setUpdatedAt(domain.getUpdatedAt());
    }
}
