package com.bsc.common.json;
import java.io.Serializable;
import java.util.Objects;

public class responseResult<T> implements Serializable {
    private static final long serialVersionUID = -3421596928908199683L;
    private Integer state;
    private String message;
    private T data;

    public responseResult(Integer state) {
        this.state = state;
    }

    public responseResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public responseResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }

    public responseResult(Integer state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        responseResult<?> that = (responseResult<?>) o;
        return Objects.equals(state, that.state) &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(state, message, data);
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
