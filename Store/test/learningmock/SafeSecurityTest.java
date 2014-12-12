package learningmock;

import com.clouway.store.learnmocks.DataBase;
import com.clouway.store.learnmocks.FingerScanner;
import com.clouway.store.learnmocks.Person;
import com.clouway.store.learnmocks.Safe;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class SafeSecurityTest {
  Safe safe;
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  @Mock
  FingerScanner fingerScanner;
  @Mock
  DataBase dataBase;

  @Before
  public void setUp() {
    safe = new Safe(fingerScanner, dataBase);
  }

  @Test
  public void openSafeDoor() {
    final Person person = new Person("Ivan", 123456789);
    context.checking(new Expectations(){{
      oneOf(fingerScanner).scanFinger(person);
      will(returnValue(person.getBiometricData()));

      oneOf(dataBase).checkInDb(person.getBiometricData());
      will(returnValue(true));
    }});
    safe.checkPerson(person);
    assertThat(safe.openDoor(), is(true));
  }

  @Test
  public void notOpenSafeDoorIfInvalidBiometricData(){
    final Person person = new Person("Georgi", 987654321);
    context.checking(new Expectations(){{
      oneOf(fingerScanner).scanFinger(person);
      will(returnValue(person.getBiometricData()));

      oneOf(dataBase).checkInDb(person.getBiometricData());
      will(returnValue(false));
    }});
    safe.checkPerson(person);
    assertThat(safe.openDoor(), is(false));
  }

  @Test
  public void cannotGetBiometricData(){
    final Person person = new Person("Georgi", 987654321);
    context.checking(new Expectations(){{
      never(fingerScanner).scanFinger(person);
      will(returnValue(person.getBiometricData()));

      never(dataBase).checkInDb(person.getBiometricData());
      will(returnValue(false));

    }});
    assertThat(safe.openDoor(), is(false));
  }
}
