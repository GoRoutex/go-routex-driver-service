package vn.com.routex.driver.service.application.services.common;

/**
 * Application-level error codes/messages.
 * <p>
 * Interfaces and infrastructure may reference these, but application/domain must not depend on outer layers.
 */
public class ErrorConstant {

    public static final String SYSTEM_ERROR = "6800";
    public static final String SYSTEM_ERROR_MESSAGE = "System Error";
    public static final String TIMEOUT_ERROR = "0600";
    public static final String TIMEOUT_ERROR_MESSAGE = "Timeout";
    public static final String RECORD_NOT_FOUND = "1407";
    public static final String VEHICLE_NOT_FOUND_MESSAGE = "Vehicle not found";
    public static final String BOOKING_NOT_FOUND_MESSAGE = "Booking not found";
    public static final String ROUTE_ASSIGNMENT_NOT_FOUND = "Route Assignment not found";
    public static final String RECORD_NOT_FOUND_MESSAGE = "Record not found";
    public static final String SUCCESS_CODE = "0000";
    public static final String SUCCESS_MESSAGE = "Success";
    public static final String DRIVER_NOT_FOUND_MESSAGE = "Driver Profile not found";
    public static final String USER_NOT_FOUND_MESSAGE = "User Profile not found";
    public static final String ROUTE_NOT_FOUND_MESSAGE = "Route not found";

    public static final String INVALID_HTTP_REQUEST_RESOURCE_ERROR = "4000";
    public static final String INVALID_HTTP_REQUEST_RESOURCE_ERROR_MESSAGE = "Resource %s path is not exists";

    public static final String INVALID_INPUT_ERROR = "0310";
    public static final String INVALID_INPUT_MESSAGE = "Invalid Input";
    public static final String INVALID_REQUEST_TIMESTAMP = "5186";
    public static final String DUPLICATE_ERROR = "9400";
    public static final String RECORD_EXISTS = "Record is already existed";
}

