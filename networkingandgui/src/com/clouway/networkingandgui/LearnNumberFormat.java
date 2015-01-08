package com.clouway.networkingandgui;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class LearnNumberFormat {
  public static void main(String[] args) {
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("da", "DK"));
    numberFormat.setCurrency(Currency.getInstance("EUR"));
    String currencyString = numberFormat.format(13.5);
    System.out.println(currencyString);

    Locale locale = new Locale("da", "DK");
    NumberFormat percentageFormat = NumberFormat.getPercentInstance(locale);
    String percentage = percentageFormat.format(999.999);
    System.out.println(percentage);

    DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
    Date date = new Date();
    System.out.println(dateFormat.format(date));
    System.out.println(date);

    LearnGuava guava = new LearnGuava();
    try {
      guava.run();
      System.out.println("asd");
    } catch (Exception e) {
      e.printStackTrace();
    }
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    try {
      guava.shutDown();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
