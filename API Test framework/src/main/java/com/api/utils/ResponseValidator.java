package com.api.utils;

import io.restassured.response.Response;
import org.testng.Assert;

public final class ResponseValidator {

    private ResponseValidator() {
    }

    public static void verifyStatusCode(Response response, int expectedStatus) {
        Assert.assertEquals(response.getStatusCode(), expectedStatus,
                "Expected status code did not match");
    }

    public static void verifyContentTypeJson(Response response) {
        Assert.assertTrue(response.getContentType().contains("application/json"),
                "Response content type is not JSON");
    }
}
