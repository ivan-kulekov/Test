package mocksms;

import mocksms.two.SMS;
import mocksms.two.Validator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ValidatorTest {
  Validator validator;

  @Before
  public void setUp() {
    validator = new Validator();
  }

  @Test
  public void sendSMS() {
    SMS sms = new SMS("0123456789", "title", "body");
    assertThat(validator.isValid(sms), is(true));
  }

  @Test
  public void notSendSMSIfInvalidNumber() {
    SMS sms = new SMS("sdf", "title", "body");
    assertThat(validator.isValid(sms), is(false));
  }

  @Test
  public void notSendSMSIfNoTitle() {
    SMS sms = new SMS("0123456789", "", "body");
    assertThat(validator.isValid(sms), is(false));
  }

  @Test
  public void notSendSMSIfNoBody() {
    SMS sms = new SMS("0123456789", "title", "");
    assertThat(validator.isValid(sms), is(false));
  }

  @Test
  public void notSendSMSIfBodyIsOutOfBound() {
    SMS sms = new SMS("0123456789", "title", "dfshkmnsd;hlkmfsdghmrtjiornmlkfdsmh,.fmg'dsf'adlg,asd'tgmrelakygnel;nyh;oreuanygrlka;tgmnlkar'tgaergyareghrdgertreatgertert");
    assertThat(validator.isValid(sms), is(false));
  }
  
  @Test
  public void notSendSMSIfNumberIsMoreThan14Numbers(){
    SMS sms = new SMS("012345678912345", "title", "body");
    assertThat(validator.isValid(sms), is(false));
  }

}
