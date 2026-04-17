package vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.operationpoint.model.OperationPointStatus;
import vn.com.routex.driver.service.domain.operationpoint.model.OperationPointType;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.shared.entity.AbstractAuditingEntity;

@Entity
@Table(name = "OPERATION_POINT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class OperationPointEntityAbstract extends AbstractAuditingEntity {
    @Id
    private String id;

    @Column(name = "MERCHANT_ID")
    private String merchantId;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private OperationPointType type;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private OperationPointStatus status;
}
