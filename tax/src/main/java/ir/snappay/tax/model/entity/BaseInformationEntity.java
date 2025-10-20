package ir.snappay.tax.model.entity;

import ir.snappay.common.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="BASE_INFORMATION")
@Data
public class BaseInformationEntity extends BaseEntity {
    @Id
    private Long id;
    @Column(name = "BASE_NAME")
    private String name;
    @Column(name="AMOUNT")
    private Double amount;
}
