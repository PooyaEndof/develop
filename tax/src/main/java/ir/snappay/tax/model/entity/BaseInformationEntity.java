package ir.snappay.tax.model.entity;

import ir.snappay.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="BASE_INFORMATION")
@Data
public class BaseInformationEntity extends BaseEntity {
    @Id
    @SequenceGenerator(name = "BASE_INFORMATION_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "BASE_INFORMATION_SEQ")
    private Long id;
    @Column(name = "BASE_NAME")
    private String name;
    @Column(name="AMOUNT")
    private Double amount;
}
