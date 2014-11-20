package mocksms.two;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class SMS {
  private final String number;
  private final String title;
  private final String body;

  public SMS(String number, String title, String body) {
    this.number = number;
    this.title = title;
    this.body = body;
  }

  public String getNumber() {
    return number;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }
}
