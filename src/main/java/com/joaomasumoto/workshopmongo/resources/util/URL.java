package com.joaomasumoto.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class URL {

    public static String decodeParam(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static Date convertDate(String textDate, Date defaultDate) {
        if (textDate == null || textDate.isBlank()) {
            return defaultDate;
        }
        try {
            LocalDate localDate = LocalDate.parse(textDate, DateTimeFormatter.ISO_LOCAL_DATE);
            return Date.from(localDate.atStartOfDay(ZoneOffset.UTC).toInstant());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date. Expected format: yyyy-MM-dd");
        }
    }
}