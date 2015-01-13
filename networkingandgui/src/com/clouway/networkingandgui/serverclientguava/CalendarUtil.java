package com.clouway.networkingandgui.serverclientguava;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class CalendarUtil {
  public static String date(int day, int month, int year) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.DAY_OF_MONTH, day);
    calendar.set(calendar.MONTH, month - 1);
    calendar.set(calendar.YEAR, year);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    String date = simpleDateFormat.format(calendar.getTime());
    return date;
  }
}
