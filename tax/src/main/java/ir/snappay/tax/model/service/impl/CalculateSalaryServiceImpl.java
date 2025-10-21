package ir.snappay.tax.model.service.impl;

import ir.snappay.tax.dto.RequestDto;
import ir.snappay.tax.dto.ResponseDto;
import ir.snappay.tax.model.entity.BaseInformationEntity;
import ir.snappay.tax.model.repository.BaseInformationRepository;
import ir.snappay.tax.model.repository.RangeTaxRepository;
import ir.snappay.tax.model.service.CalculateSalaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalculateSalaryServiceImpl implements CalculateSalaryService {

    private final RangeTaxRepository taxRepository;
    private final BaseInformationRepository baseInformationRepository;

    @Transactional
    public ResponseDto operate(RequestDto requestDto) {
        List<BaseInformationEntity> baseInformationEntityList = baseInformationRepository.findAll();
        double insurancePercent=baseInformationEntityList.stream().filter((x)->x.getName().equals("insurance"))
                .map(BaseInformationEntity::getAmount).findFirst().orElse(0d);
        double homeAmount=baseInformationEntityList.stream().filter((x)->x.getName().equals("home"))
                .map(BaseInformationEntity::getAmount).findFirst().orElse(0d);
        double transport=baseInformationEntityList.stream().filter((x)->x.getName().equals("transport"))
                .map(BaseInformationEntity::getAmount).findFirst().orElse(0d);
        //requestDto.getTotalSalary() *
        return null;
    }
}
