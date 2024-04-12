package com.robo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomGenericException extends RuntimeException {

    private static final long serialVersionUID = 2457692790458351108L;

    private String errMsg;
    private HttpStatus statusCode;
    private Exception ex;

    public CustomGenericException(HttpStatus statusCode, Exception ex) {
        this.statusCode = statusCode;
        this.ex = ex;
    }

    public CustomGenericException(String errMsg, HttpStatus statusCode) {
        this(statusCode, null);
        this.errMsg = errMsg;
    }

    public CustomGenericException(String errMsg) {
        this(errMsg, HttpStatus.BAD_REQUEST);
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getErrMsg() {

        if (ex != null) {
            errMsg = ex.getLocalizedMessage();
        }

        return errMsg;
    }

    public String getEx() {
        if(ex != null) {
            return ex.getClass().getSimpleName();
        } else {
            return "CustomGenericException";
        }
    }
}

