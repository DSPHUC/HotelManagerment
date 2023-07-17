package utils;

import Model.Distance;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeCalculator {
    public static int timeCalculator(LocalDateTime checkIn, LocalDateTime checkOut) {

        double duration = (double) ChronoUnit.HOURS.between(checkIn, checkOut) / 24;
        double result = duration % 1;
        if (result >= 0.5) {
            duration++;
        }
        return (int) duration;
//        return duration;
    }

    public static Distance getDistance(String In, String Out) {
        try {
            LocalDateTime checkIn = AppUtils.getDateTime(In);
//            System.out.println("Your meeting is at " + checkIn);
            LocalDateTime checkOut = AppUtils.getDateTime(Out);
//            System.out.println("Your meeting is at " + checkOut);
            double duration = (double) ChronoUnit.HOURS.between(checkIn, checkOut) / 24;
//            System.out.println("The duration between now and your meeting is " + duration + " hours.");
            Distance distance = new Distance( checkIn,  checkOut, duration);
            return distance;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getDistance(In, Out);
        }
    }


//    public static void main(String[] args) {
//        System.out.println(timeCalculator("2023-07-11 12:00:00", "2023-07-12 00:00:00"));
//
//    }
}
