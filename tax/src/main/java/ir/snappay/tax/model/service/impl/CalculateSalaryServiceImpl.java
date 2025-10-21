package ir.snappay.tax.model.service.impl;

import ir.snappay.tax.dto.RequestDto;
import ir.snappay.tax.dto.ResponseDto;
import ir.snappay.tax.model.entity.BaseInformationEntity;
import ir.snappay.tax.model.entity.RangeTaxEntity;
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
        double tax=calculateTax(requestDto.getTotalSalary()-homeAmount-transport); // that salary must minus from total like transport and home
        double insurance=requestDto.getTotalSalary() * insurancePercent/100;
        return ResponseDto.builder().totalSalary(requestDto.getTotalSalary()).insurance(insurance).tax(tax)
                .netSalary(requestDto.getTotalSalary()-tax-insurance).build();
    }

    private double calculateTax(double salary) {
        List<RangeTaxEntity> list=taxRepository.findByLowRangeLessThanOrderByLowRangeAsc(salary);
        return list.parallelStream().map((rangeTaxEntity)-> {
            double highRange = rangeTaxEntity.getHighRange() > salary ? salary : rangeTaxEntity.getHighRange();
            return (highRange - rangeTaxEntity.getLowRange()) * rangeTaxEntity.getPercent()/100;
        }).reduce(Double::sum).orElse(0d);

    }
}
