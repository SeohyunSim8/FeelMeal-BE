package feelmeal.global.utils;

import feelmeal.global.common.exception.CustomException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static feelmeal.global.common.exception.ResponseCode.INVALID_CREATE_THEME_REVIEW_DATE;
import static feelmeal.global.common.exception.ResponseCode.INVALID_CREATE_THEME_REVIEW_TIME;

public class DateUtils {
    public static LocalDate stringToLocalDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new CustomException(INVALID_CREATE_THEME_REVIEW_DATE);
        }
    }

    public static LocalTime stringToLocalTime(String time) {
        try {
            String[] parts = time.split(":");
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);

            // 60분 이상일 경우 시간을 따로 계산
            int hours = minutes / 60;
            minutes = minutes % 60;

            return LocalTime.of(hours, minutes, seconds);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new CustomException(INVALID_CREATE_THEME_REVIEW_TIME);
        }
    }
}
