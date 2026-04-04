package vn.com.routex.driver.service.domain.stoppoint.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.shared.model.AbstractAuditingEntity;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StopPoint extends AbstractAuditingEntity {
    private String id;

    private String name;

    private String address;

    private BigDecimal latitude; // Vi Do

    private BigDecimal longitude; // Kinh do

    private StopType type;
}
