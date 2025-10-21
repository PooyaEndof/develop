package ir.snappay.tax.controller;

import ir.snappay.tax.dto.RequestDto;
import ir.snappay.tax.dto.ResponseDto;
import ir.snappay.tax.model.service.CalculateSalaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary")
@RequiredArgsConstructor
public class SalaryController {

    private final CalculateSalaryService service;

    @PostMapping("/operation")
    public ResponseEntity<ResponseDto> operation(@Valid @RequestBody RequestDto requestDto) {
        return new ResponseEntity<>(service.operate(requestDto),HttpStatus.OK);
    }
}
