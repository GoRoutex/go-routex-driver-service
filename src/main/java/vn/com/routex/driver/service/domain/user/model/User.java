package vn.com.routex.driver.service.domain.user.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.shared.model.AbstractAuditingEntity;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User extends AbstractAuditingEntity {

    private String id;

    private String username;

    private String fullName;

    private String passwordHash;

    private LocalDate dob;

    private String phoneNumber;

    private Boolean phoneVerified = false;

    private String email;

    private Boolean emailVerified = false;

    private UserStatus status;

    private String tenantId;

    private String language;

    private String timezone;

    private Integer failLoginCount = 0;

    private OffsetDateTime lastLoginAt;

    private OffsetDateTime lockedUntil;
}
