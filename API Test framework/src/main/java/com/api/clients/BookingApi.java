package com.api.clients;

import com.api.models.Booking;
import com.api.models.BookingDates;
import com.api.utils.ApiRequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public final class BookingApi {

    private BookingApi() {
    }

    public static Response createBooking(Booking booking) {
        return given()
                .spec(ApiRequestSpecification.getDefaultSpec())
                .body(booking)
                .contentType(ContentType.JSON)
                .when()
                .post("/booking");
    }

    public static Response getBooking(int bookingId) {
        return given()
                .spec(ApiRequestSpecification.getDefaultSpec())
                .when()
                .get("/booking/" + bookingId);
    }

    public static Response deleteBooking(int bookingId, String token) {
        return given()
                .spec(ApiRequestSpecification.getDefaultSpec())
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/" + bookingId);
    }

    public static Response authenticate(String username, String password) {
        return given()
                .spec(ApiRequestSpecification.getDefaultSpec())
                .body(new AuthRequest(username, password))
                .when()
                .post("/auth");
    }

    public static class AuthRequest {
        private final String username;
        private final String password;

        public AuthRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
