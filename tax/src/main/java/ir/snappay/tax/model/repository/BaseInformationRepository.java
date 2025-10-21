package ir.snappay.tax.model.repository;

import ir.snappay.tax.model.entity.BaseInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseInformationRepository extends JpaRepository<BaseInformationEntity,Long> {
    //Optional<BaseInformationEntity> findByName(String name);
}
