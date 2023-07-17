package utils;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import static utils.Constant.DATE_TIME_FORMATTER;


public class AppUtils {
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public static String getString(String str) {
        System.out.println(str);
        return sc.nextLine();
    }

    public static int getInt(String str) {
        try {
            return Integer.parseInt(getString(str));
        } catch (Exception e) {
            System.out.println("Input invalid");
            return getInt(str);
        }
    }

    public static double getDouble(String str) {
        try {
            return Double.parseDouble(getString(str));
        } catch (Exception e) {
            System.out.println("Input invalid");
            return getDouble(str);
        }
    }

    public static int getIntWithBound(String str, int begin, int end) {
        try {
            int number = getInt(str);
            if (number < begin || number > end) {
                throw new NumberFormatException(String.format("Please input number between %d and %d", begin, end));
            }
            return number;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getIntWithBound(str, begin, end);
        }
    }

    public static Date getDate(String str) {
        try {
            System.out.println("Please enter date with format YYYY-MM-DD");
            return Date.valueOf(getString(str));
        } catch (Exception e) {
            System.out.println("Invalid Date Format");
            return getDate(str);
        }
    }

    public static Time getTime(String str) {
        try {
            System.out.println("Please enter date with format HH:MM:SS");
            String time = getString(str);
            int hour = Integer.parseInt(time.split(":")[0]);
            if (hour > 24 || hour < 0) throw new RuntimeException("Hours Invalid");
            return Time.valueOf(time);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return getTime(str);
        } catch (Exception e) {
            System.out.println("Invalid Time");
            return getTime(str);
        }
    }

    public static LocalDateTime getDateTimeNow() {
        return LocalDateTime.now();
    }

    public static LocalDateTime getDateTime(String str) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(getString(str + "Nhập ngày giờ (yyyy-MM-dd HH:mm:ss):")
                    , Constant.DATE_TIME_FORMATTER);
            LocalDateTime currentDateTime = getDateTimeNow();
            if (getDuration(currentDateTime, dateTime) < 0 || getDuration(currentDateTime, dateTime) > 525600) {
                throw new RuntimeException("Ngày nhập không hợp lệ - Vui lòng nhập ngày và giờ trong vòng 365 ngày ");
            }
            return dateTime;
        } catch (DateTimeParseException e) {
            System.out.println("Không thể đọc ngày và giờ được nhập vào." +
                    " Vui lòng kiểm tra lại định dạng (dd-MM-yyyy hh:mm:ss).");
            return getDateTime(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getDateTime(str);
        }
    }

    public static LocalDateTime getCheckInDate() {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(getString(
                            "ngày vào " + "Nhập ngày giờ (yyyy-MM-dd HH:mm:ss):")
                    , Constant.DATE_TIME_FORMATTER);
            LocalDateTime currentDateTime = getDateTimeNow();
            if (getDuration(currentDateTime, dateTime) < 0 ||
                    getDuration(currentDateTime, dateTime) > 365) {
                throw new RuntimeException(
                        "Ngày nhập không hợp lệ - Vui lòng nhập ngày và giờ trong vòng 365 ngày ");
            }
            return dateTime;
        } catch (DateTimeParseException e) {
            System.out.println("Không thể đọc ngày và giờ được nhập vào." +
                    " Vui lòng kiểm tra lại định dạng (yyyy-MM-dd HH:mm:ss).");
            return getCheckInDate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCheckInDate();
        }
    }

    public static LocalDateTime getCheckOutDate(LocalDateTime checkinDate) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(getString("ngày ra " + "Nhập ngày giờ (yyyy-MM-dd HH:mm:ss):")
                    , Constant.DATE_TIME_FORMATTER);
            if (getDuration(checkinDate, dateTime) < 0.5 || getDuration(checkinDate, dateTime) > 365) {
                throw new RuntimeException("Ngày nhập không hợp lệ - Vui lòng nhập ngày và giờ trong vòng từ 1-365 ngày so với thời gian nhập ");
            }
            return dateTime;
        } catch (DateTimeParseException e) {
            System.out.println("Không thể đọc ngày và giờ được nhập vào." +
                    " Vui lòng kiểm tra lại định dạng (yyyy-MM-dd HH:mm:ss).");
            return getCheckOutDate(checkinDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCheckOutDate(checkinDate);
        }
    }

    public static LocalDateTime DateTimeCalculator(LocalDateTime checkIn, LocalDateTime checkOut) {
        long diffInDays = ChronoUnit.DAYS.between(getDateTime(String.valueOf(checkIn))
                , getDateTime(String.valueOf(checkOut)));
        System.out.println("Days: " + diffInDays);
        LocalDateTime result = LocalDateTime.parse(String.valueOf(checkIn)
                , DateTimeFormatter.ofPattern(String.valueOf(checkOut)));
        return result;
    }

    public static LocalDateTime parseDateTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(input, DATE_TIME_FORMATTER);
    }


    public static int getDuration(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        return (int) ChronoUnit.HOURS.between(startTime, endTime) / 24;
    }

    public static int getNextId(List<Integer> integerList) {
        return integerList.stream().max(Integer::compareTo).orElse(0) + 1;
    }

    public static void main(String[] args) {
//        getCheckInDate();
//        getCheckOutDate(getCheckInDate());
//        2023-07-11 12:00:00
        LocalDateTime checkIn = AppUtils.getCheckInDate();
        System.out.println("Your meeting is at " + checkIn);
        LocalDateTime checkOut = AppUtils.getCheckOutDate(checkIn);
        System.out.println("Your meeting is at " + checkOut);
        double duration = (double) ChronoUnit.HOURS.between(checkIn, checkOut) / 24;
        System.out.println("The duration between now and your is " + duration + " hours.");
    }


}
