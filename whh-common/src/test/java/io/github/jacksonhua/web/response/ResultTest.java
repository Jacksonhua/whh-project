package io.github.jacksonhua.web.response;

import io.github.jacksonhua.common.web.response.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @Test
    public void testSuccess() {
        Result<String> result = Result.success("Hello, World!");
        assertEquals(0, result.getCode());
        assertEquals("success", result.getMsg());
        assertEquals("Hello, World!", result.getData());
        Result<Void> error = Result.error("Error");
        assertEquals(500, error.getCode());
        assertEquals("Error", error.getMsg());
        assertNull(error.getData());
        Result<Void> success = Result.success();
        success.correlationId("2wq");
        assertEquals("2wq", success.getCorrelationId());
        System.out.println("success.getTimestamp() = " + success.getTimestamp());

        success.code(200);
        success.msg("success1");
        success.data(null);

    }

}