package com.nasa.model.beans;

import java.io.Serializable;

/**
 * POJO to delivery error message.
 *
 * @author marcos.barbero
 */
public class ErrorResource implements Serializable {
    private static final long serialVersionUID = -3559384193793803641L;

    private String code;
    private String message;

    public ErrorResource(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
