package com.clouway.networkingandgui;

import java.text.NumberFormat;
import java.util.Currency;
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
    String percentage = percentageFormat.format(99.999);
    System.out.println(percentage);
  }
}
