package ir.snappay.tax.model.service;

import ir.snappay.tax.dto.RequestDto;
import ir.snappay.tax.dto.ResponseDto;

public interface CalculateSalaryService {

    ResponseDto operate(RequestDto requestDto);
}
