package vn.com.routex.driver.service.infrastructure.persistence.adapter.user.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.user.model.User;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper.AuditPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.user.entity.UserJpaEntity;

@UtilityClass
public class UserPersistenceMapper {
    public User toDomain(UserJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        User domain = User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .fullName(entity.getFullName())
                .passwordHash(entity.getPasswordHash())
                .dob(entity.getDob())
                .phoneNumber(entity.getPhoneNumber())
                .phoneVerified(entity.getPhoneVerified())
                .email(entity.getEmail())
                .emailVerified(entity.getEmailVerified())
                .status(entity.getStatus())
                .tenantId(entity.getTenantId())
                .language(entity.getLanguage())
                .timezone(entity.getTimezone())
                .failLoginCount(entity.getFailLoginCount())
                .lastLoginAt(entity.getLastLoginAt())
                .lockedUntil(entity.getLockedUntil())
                .build();
        AuditPersistenceMapper.toDomain(domain, entity);
        return domain;
    }

    public UserJpaEntity toEntity(User domain) {
        if (domain == null) {
            return null;
        }
        UserJpaEntity entity = UserJpaEntity.builder()
                .id(domain.getId())
                .username(domain.getUsername())
                .fullName(domain.getFullName())
                .passwordHash(domain.getPasswordHash())
                .dob(domain.getDob())
                .phoneNumber(domain.getPhoneNumber())
                .phoneVerified(domain.getPhoneVerified())
                .email(domain.getEmail())
                .emailVerified(domain.getEmailVerified())
                .status(domain.getStatus())
                .tenantId(domain.getTenantId())
                .language(domain.getLanguage())
                .timezone(domain.getTimezone())
                .failLoginCount(domain.getFailLoginCount())
                .lastLoginAt(domain.getLastLoginAt())
                .lockedUntil(domain.getLockedUntil())
                .build();
        return entity;
    }
}
