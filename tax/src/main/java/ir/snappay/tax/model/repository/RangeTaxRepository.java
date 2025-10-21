package ir.snappay.tax.model.repository;

import ir.snappay.tax.model.entity.RangeTaxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RangeTaxRepository extends JpaRepository<RangeTaxEntity,Long> {
    Optional<RangeTaxEntity> findTopByLowRangeGreaterThanOrderByLowRangeDesc(double lowRange);
}
