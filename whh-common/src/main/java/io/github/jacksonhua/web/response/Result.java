package io.github.jacksonhua.web.response;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

@Data
public class Result<T> {
    private Integer code = 0;

    private String msg = "success";

    private T data;
    /**
     * 追踪id
     */
    private String correlationId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime timestamp;

    public Result() {
        this.timestamp = OffsetDateTime.now();
    }
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        return result;
    }
    public static <T> Result<T> success() {
        return success(null);
    }
    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static <T> Result<T> error(String msg) {
        return error(500, msg);
    }
    public Result<T> data(T data) {
        this.setData(data);
        return this;
    }
    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }
    public Result<T> msg(String msg) {
        this.setMsg(msg);
        return this;
    }
    public Result<T> correlationId(String requestId) {
        this.setCorrelationId(requestId);
        return this;
    }





}
