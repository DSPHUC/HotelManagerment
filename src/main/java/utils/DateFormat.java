package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    private static SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");


    public static void convertDateTypeWithHours(Date date){
        SimpleDateFormat formatterDayWithHours = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String formattedDate = formatterDayWithHours.format(date);

    }


    public static String convertDateToString(Date date) {
        return simpleDateFormat1.format(date);
    }

    private static final String FORMAT_PATTERN = "dd-MM-yyyy hh:mm:ss";

    public static String formatDateWithHours(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_PATTERN);
        return formatter.format(date);
    }



    public static Date parseDateWithHours(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_PATTERN);
        try {
            return formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
