import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class SampleTest {

  class AgeFinder {
    public int getAge() {
      return 23;
    }
  }

  class Person {
    private final AgeFinder ageFinder;

    public Person(AgeFinder ageFinder) {
      this.ageFinder = ageFinder;
    }

    public boolean isAdult(){
      if (ageFinder.getAge() <= 18) {
        return false;
      }

      return true;
    }
  }


  @Test
  public void test() {
   AgeFinder finder = new AgeFinder() {
     @Override
     public int getAge() {
       return 10;
     }
   };
   Person person = new Person(finder);
    assertThat(person.isAdult(),is(false));


  }
}
