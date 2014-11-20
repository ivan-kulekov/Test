package mocksms.two;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Validator {
  public boolean isValid(SMS sms1) {
    try {
      Integer.parseInt(sms1.getNumber());
      if (sms1.getNumber().length() > 14 || sms1.getNumber().length() < 10){
        return false;
      }
    }catch (NumberFormatException e){
      return false;
    }
    return !sms1.getTitle().equals("") && !(sms1.getBody().equals("") || sms1.getBody().length() > 120);
  }
}
