package ir.snappay.common.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@MappedSuperclass
@Data
public class BaseEntity {
    @CreatedDate
    private LocalDate createDate;
    @LastModifiedDate
    private LocalDate modifiedDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;
}
