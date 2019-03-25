package com.api.orchestrator.finance.utils;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ErrorModel implements Serializable {
    private static final long serialVersionUID = -1264215612995673890L;
    private String code;
    private String message;

    public ErrorModel(HttpStatus status, String message) {
        this.code = status.toString();
        this.message = message;
    }

    public String toJSON() {
        return ParserUtil.convertToJSON(this);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorModel() {
    }

    public ErrorModel(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
