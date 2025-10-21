package ir.snappay.common.enums;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    TOTAL_SALARY_INVALID("total.salary.invalid","ERR0001");

    private final String code;
    private final String key;

    ErrorEnum(String key,String code) {
        this.code = code;
        this.key = key;
    }
}
