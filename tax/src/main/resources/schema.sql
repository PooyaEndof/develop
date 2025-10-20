CREATE TABLE BASE_INFORMATION (
                                  ID BIGINT PRIMARY KEY AUTO_INCREMENT,
                                  BASE_NAME VARCHAR(255) NOT NULL,
                                  AMOUNT BIGINT
);

CREATE TABLE RANGE_TAX (
                           ID BIGINT PRIMARY KEY AUTO_INCREMENT,
                           LOW_RANGE BIGINT NOT NULL,
                           HIGH_RANGE BIGINT,
                           PERCENT INT
);