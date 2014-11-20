package mocksms;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class SmsTest {

  @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
  @Mock Validator validator;
  @Mock Gateway gateway;

  @Test
  public void sendSMS(){
    Dispacher dispacher = new Dispacher(validator, gateway);
    final SMS sms = new SMS();
    context.checking(new Expectations(){{
      oneOf(validator).isValid(sms);
      will(returnValue(true));
      oneOf(gateway).send(sms);
    }});
    dispacher.sendSms(sms);
  }

  @Test
  public void notSendSMSIfInvalid(){
    Dispacher dispacher = new Dispacher(validator, gateway);
    final SMS sms = new SMS();
    context.checking(new Expectations(){{
      oneOf(validator).isValid(sms);
      will(returnValue(false));
    }});
    dispacher.sendSms(sms);
  }
}
