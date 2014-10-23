import com.clouway.test.shop.AddMoreThanMaxQuantityException;
import com.clouway.test.shop.ProductNotFoundException;
import com.clouway.test.shop.SellMoreThanMinQuantityException;
import com.clouway.test.shop.Shop;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ShopTest {
  @Test
  public void sellProduct() throws Exception {
    Shop shop = new Shop();
    shop.add("apple", 15, 1.45, 20);
    int quantity = shop.sell("apple", 10);
    assertThat(quantity, is(5));
  }

  @Test
  public void sellProduct1() throws Exception {
    Shop shop = new Shop();
    shop.add("apple", 10, 1.45, 20);
    int quantity = shop.sell("apple", 10);
    assertThat(quantity, is(0));
  }

  @Test
  public void addProducts() throws Exception {
    Shop shop = new Shop();
    shop.add("apple", 10, 1.45, 20);
    int quantity =  shop.add("kiwi", 5, 1.80, 15);
    assertThat(quantity, is(2));
  }

  @Test
  public void addProducts1() throws Exception {
    Shop shop = new Shop();
    shop.add("apple", 10, 1.45, 20);
    shop.add("orange", 8, 2.45, 10);
    int quantity =  shop.add("kiwi", 5, 1.80, 15);
    assertThat(quantity, is(3));
  }

  @Test
  public void sortProductsByPrice() throws Exception {
    Shop shop = new Shop();
    shop.add("apple", 10, 1.45, 20);
    shop.add("orange", 8, 2.45, 10);
    shop.add("kiwi", 5, 1.80, 15);
    double quantity = shop.sort();
    assertThat(quantity, is(2.45));
  }

  @Test
  public void sortProductsByPrice1() throws Exception {
    Shop shop = new Shop();
    shop.add("apple", 10, 1.45, 20);
    shop.add("orange", 8, 2.45, 10);
    shop.add("kiwi", 5, 1.80, 15);
    shop.add("banana", 3, 3.1, 12);
    double quantity = shop.sort();
    assertThat(quantity, is(3.1));
  }

  @Test(expected = ProductNotFoundException.class)
  public void sellNotExistingProduct() throws Exception {
    Shop shop = new Shop();
    shop.add("apple", 15, 1.45, 20);
    shop.sell("orange", 10);
  }

  @Test
  public void addTwoSameProducts() throws Exception {
    Shop shop = new Shop();
    shop.add("orange", 12, 2.45, 20);
    shop.add("apple", 10, 1.45, 20);
    int quantity = shop.add("apple", 5, 1.45, 20);
    assertThat(quantity, is(2));
  }

  @Test
  public void addTwoSameProducts1() throws Exception {
    Shop shop = new Shop();
    shop.add("orange", 12, 2.45, 20);
    shop.add("orange", 5, 2.45, 20);
    shop.add("apple", 10, 1.45, 20);
    int quantity = shop.add("apple", 5, 1.45, 20);
    assertThat(quantity, is(2));
  }

  @Test(expected = AddMoreThanMaxQuantityException.class)
  public void addMoreThanMaxQuantity() throws Exception {
    Shop shop = new Shop();
    shop.add("apple", 25, 1.45, 20);
  }

  @Test(expected = AddMoreThanMaxQuantityException.class)
  public void addMoreThanMaxQuantityTwoSameProducts() throws Exception {
    Shop shop = new Shop();
    shop.add("apple", 16, 1.45, 20);
    shop.add("apple", 5, 1.45, 20);
  }

  @Test
  public void sellTwoSameProducts() throws Exception {
    Shop shop = new Shop();
    shop.add("orange", 12, 2.45, 20);
    shop.sell("orange", 5);
    int quantity = shop.sell("orange", 2);
    assertThat(quantity, is(5));
  }

  @Test(expected = SellMoreThanMinQuantityException.class)
  public void sellMoreThanMinQuantity() throws Exception {
    Shop shop = new Shop();
    shop.add("orange", 12, 2.45, 20);
    shop.add("orange", 5, 2.45, 20);
    shop.sell("orange", 18);

  }

  @Test
  public void sellEqualsQuantityProduct() throws Exception {
    Shop shop = new Shop();
    shop.add("apple", 10, 1.45, 20);
    int quantity = shop.sell("apple", 10);
    assertThat(quantity, is(0));
  }
}
