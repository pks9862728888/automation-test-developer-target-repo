package com.helper.testgenerator.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDAO {
    private String message;
    private int statusCode;
    private String exceptionType;
}
