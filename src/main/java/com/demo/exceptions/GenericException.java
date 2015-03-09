package com.demo.exceptions;

/**
 * Created by pingping on 三月/8/15.
 */
public class GenericException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String customMsg;
    public String message;

    public String getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(String customMsg) {
        this.customMsg = customMsg;
    }

    public GenericException(String customMsg) {
        this.customMsg = customMsg;
    }

    @Override
    public String getMessage() {
        return message;
    }

}