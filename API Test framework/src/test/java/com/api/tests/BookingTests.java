package com.api.tests;

import com.api.base.BaseTest;
import com.api.clients.BookingApi;
import com.api.config.ConfigManager;
import com.api.models.Booking;
import com.api.models.BookingDates;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingTests extends BaseTest {

    private String authToken;

    @BeforeClass
    public void authenticate() {
        Response authResponse = BookingApi.authenticate(ConfigManager.getUsername(), ConfigManager.getPassword());
        authToken = authResponse.then().statusCode(200).extract().path("token");
        log.info("Authenticated and retrieved token: {}", authToken);
    }

    @Test(description = "Create a booking and verify the response payload")
    @Description("Verify that a new booking can be created and returned values match the payload")
    public void shouldCreateBooking() {
        Booking booking = new Booking(
                "John",
                "Doe",
                250,
                true,
                new BookingDates("2025-10-01", "2025-10-05"),
                "Breakfast"
        );

        Response response = BookingApi.createBooking(booking);
        response.then().statusCode(200);

        int bookingId = response.jsonPath().getInt("bookingid");
        Booking createdBooking = response.jsonPath().getObject("booking", Booking.class);

        Assert.assertEquals(createdBooking.getFirstName(), booking.getFirstName());
        Assert.assertEquals(createdBooking.getLastName(), booking.getLastName());
        Assert.assertEquals(createdBooking.getTotalPrice(), booking.getTotalPrice());
        Assert.assertEquals(createdBooking.isDepositPaid(), booking.isDepositPaid());
        Assert.assertEquals(createdBooking.getBookingDates().getCheckin(), booking.getBookingDates().getCheckin());
        Assert.assertEquals(createdBooking.getBookingDates().getCheckout(), booking.getBookingDates().getCheckout());
        Assert.assertEquals(createdBooking.getAdditionalNeeds(), booking.getAdditionalNeeds());

        log.info("Booking created with id {}", bookingId);
    }

    @Test(description = "Retrieve an existing booking by ID and verify it returns a success status")
    @Description("Fetch a booking and validate that the API returns 200 with expected booking payload structure")
    public void shouldGetBookingById() {
        Booking booking = new Booking(
                "Jane",
                "Smith",
                180,
                false,
                new BookingDates("2025-11-15", "2025-11-20"),
                "Lunch"
        );
        int bookingId = BookingApi.createBooking(booking)
                .then().statusCode(200)
                .extract().path("bookingid");

        Response response = BookingApi.getBooking(bookingId);
        response.then().statusCode(200);

        Booking retrieved = response.as(Booking.class);
        Assert.assertEquals(retrieved.getFirstName(), booking.getFirstName());
        Assert.assertEquals(retrieved.getLastName(), booking.getLastName());
        log.info("Retrieved booking {} successfully", bookingId);
    }
}
