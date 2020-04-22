package com.sistema.produto.gerenciarconta.excecoes.error;


import java.util.Objects;

public class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }


    public ApiValidationError() {
    }

    public ApiValidationError(String object, String field, Object rejectedValue, String message) {
        this.object = object;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = message;
    }

    public String getObject() {
        return this.object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return this.rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApiValidationError object(String object) {
        this.object = object;
        return this;
    }

    public ApiValidationError field(String field) {
        this.field = field;
        return this;
    }

    public ApiValidationError rejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
        return this;
    }

    public ApiValidationError message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ApiValidationError)) {
            return false;
        }
        ApiValidationError apiValidationError = (ApiValidationError) o;
        return Objects.equals(object, apiValidationError.object) && Objects.equals(field, apiValidationError.field) && Objects.equals(rejectedValue, apiValidationError.rejectedValue) && Objects.equals(message, apiValidationError.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object, field, rejectedValue, message);
    }

    @Override
    public String toString() {
        return "{" +
                " object='" + getObject() + "'" +
                ", field='" + getField() + "'" +
                ", rejectedValue='" + getRejectedValue() + "'" +
                ", message='" + getMessage() + "'" +
                "}";
    }


}