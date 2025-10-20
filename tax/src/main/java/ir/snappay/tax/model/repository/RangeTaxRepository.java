package ir.snappay.tax.model.repository;

import ir.snappay.tax.model.entity.RangeTaxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RangeTaxRepository extends JpaRepository<RangeTaxEntity,Long> {
}
