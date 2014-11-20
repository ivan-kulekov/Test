package mocksms;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Dispacher {
  private final Validator validator;
  private final Gateway gateway;

  public Dispacher(Validator validator, Gateway gateway) {

    this.validator = validator;
    this.gateway = gateway;
  }

  public void sendSms(SMS sms) {
    if (validator.isValid(sms)) {
      gateway.send(sms);
    }
  }
}
