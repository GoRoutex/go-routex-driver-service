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
import vn.com.routex.driver.service.domain.stoppoint.model.StopType;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.shared.entity.AuditingJpaEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "STOP_POINT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class StopPointJpaEntity extends AuditingJpaEntity {
    @Id
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "LATITUDE")
    private BigDecimal latitude; // Vi Do

    @Column(name = "LONGTITUDE")
    private BigDecimal longtitude; // Kinh do

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private StopType type;
}
