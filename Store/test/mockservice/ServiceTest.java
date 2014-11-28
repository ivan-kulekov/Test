package mockservice;

import com.clouway.store.mockservice.DataBase;
import com.clouway.store.mockservice.Person;
import com.clouway.store.mockservice.Service;
import com.clouway.store.mockservice.Validator;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServiceTest {

  Service service;

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  Validator validator;
  @Mock
  DataBase dataBase;


  @Before
  public void setUp() {
    service = new Service(validator, dataBase);
  }


  @Test
  public void addToDataBase() {
    final Person user = new Person("Ivan", "29");
    context.checking(new Expectations() {{
      oneOf(validator).isValid(user);
      will(returnValue(true));
      oneOf(dataBase).addToDb(user);
    }});

    service.addUser(user);
  }

  @Test
  public void notAddToDataBaseIfInvalid() {
    final Person user = new Person("Ivan", "129");
    context.checking(new Expectations() {{
      oneOf(validator).isValid(user);
      will(returnValue(false));
    }});

    service.addUser(user);
  }

  @Test
  public void getAgeIfIsAdult() {
    final Person user = new Person("Ivan", "25");
    context.checking(new Expectations() {{
      oneOf(dataBase).getUserAge(user);
      will(returnValue(user.getAge()));
      oneOf(validator).isAdult(user.getAge());
      will(returnValue(true));
    }});
    assertThat(service.getUser(user), is(true));
  }

  @Test
  public void getAgeIfUserIsNotAdult() {
    final Person user = new Person("Ivan", "12");
    context.checking(new Expectations() {{
      oneOf(dataBase).getUserAge(user);
      will(returnValue(user.getAge()));
      oneOf(validator).isAdult(user.getAge());
      will(returnValue(false));
    }});
    assertThat(service.getUser(user), is(false));
  }
}
