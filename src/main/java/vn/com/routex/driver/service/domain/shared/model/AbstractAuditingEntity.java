package vn.com.routex.driver.service.domain.shared.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

/**
 * Domain-level audit metadata.
 * <p>
 * Keep this type free of persistence/framework annotations (Clean Architecture).
 * Persistence-specific auditing lives in infrastructure layer.
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractAuditingEntity {
    private OffsetDateTime createdAt;
    private String createdBy;
    private String updatedBy;
    private OffsetDateTime updatedAt;
}
