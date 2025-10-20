package ir.snappay.tax.model.entity;

import ir.snappay.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="RANGE_TAX")
@Data
public class RangeTaxEntity extends BaseEntity {
    @Id
    private Long id;

    @Column(name="HIGH_RANGE")
    private Double highRange;

    @Column(name="LOW_RANGE")
    private Double lowRange;

    @Column(name="PERCENT")
    private Double percent;

}
