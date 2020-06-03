package com.sixdee.utils.exception;


import java.util.HashMap;
import java.util.Map;

import com.sixdee.utils.supporters.StringUtil;

/**
 * Class representing the exception constants and associated short error descriptions.
 */
public class ExceptionConstants {

    public final static int INTERAL_SERVER_ERROR = 500;

    public final static int BAD_GATEWAY = 502;

    public final static int SERVICE_UNAVAILABLE = 503;

    public final static int GATEWAY_TIMEOUT = 504;

    public final static int BAD_REQUEST = 400;

    public final static int UNAUTHORIZED = 401;

    public final static int FORBIDDEN = 403;

    public final static int NOT_FOUND = 404;

    public final static int REQUEST_TIMEOUT = 408;

    public final static int PRECONDITION_FAILED = 412;

    public final static int UNSUPPORTED_MEDIA_TYPE = 415;

    private static Map<Integer, String> exceptions = new HashMap<>();

    static {
        // 5xx series
        exceptions.put(INTERAL_SERVER_ERROR, "Internal server error");
        exceptions.put(BAD_GATEWAY, "Dependent system returned error");
        exceptions.put(SERVICE_UNAVAILABLE, "Service unavailable");
        exceptions.put(GATEWAY_TIMEOUT, "Dependent system timed out");

        // 4xx series
        exceptions.put(BAD_REQUEST, "Bad request from the customer");
        exceptions.put(UNAUTHORIZED, "Unauthorized. You need to be authenticated");
        exceptions.put(FORBIDDEN, "Unauthorized. You are not authorized");
        exceptions.put(NOT_FOUND, "Requested resource not found");
        exceptions.put(REQUEST_TIMEOUT, "Request timeout");
        exceptions.put(PRECONDITION_FAILED, "Precondition failed");
        exceptions.put(UNSUPPORTED_MEDIA_TYPE, "Unsupported content type");
    }

    public static String getShortError(Integer code) {
        String shortError = exceptions.get(code);
        return StringUtil.getNonNull(shortError, "Unknown error");
    }
}
