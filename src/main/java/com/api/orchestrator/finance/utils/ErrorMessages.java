package com.api.orchestrator.finance.utils;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessages {
    private List<ErrorModel> errors = new ArrayList();

    public ErrorMessages() {
    }

    public static String singleError(String codeError) {
        ErrorMessages errorMessages = new ErrorMessages();
        errorMessages.add(codeError);
        return errorMessages.toString();
    }

    public static String singleError(HttpStatus httpStatus) {
        ErrorMessages errorMessages = new ErrorMessages();
        errorMessages.add(httpStatus);
        return errorMessages.toString();
    }

    public static String singleError(String code, String message) {
        ErrorMessages errorMessages = new ErrorMessages();
        errorMessages.add(code, message);
        return errorMessages.toString();
    }

    public void add(String code, String message) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode(code);
        errorModel.setMessage(message);
        this.errors.add(errorModel);
    }

    public void addAll(List<ErrorModel> errorModel) {
        this.errors.addAll(errorModel);
    }

    public void add(HttpStatus httpStatus) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode(String.valueOf(httpStatus.value()));
        errorModel.setMessage(httpStatus.getReasonPhrase());
        this.errors.add(errorModel);
    }

    public void add(String code) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode(code);
        errorModel.setMessage(PropertiesUtil.getErrorMessage(code));
        this.errors.add(errorModel);
    }

    public int size() {
        return this.errors.size();
    }

    public void clear() {
        this.errors.clear();
    }

    public String toString() {
        return ParserUtil.convertToJSON(this.errors);
    }
}
