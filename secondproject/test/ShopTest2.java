import com.clouway.test.shop.Product;
import com.clouway.test.shop.ProductNotFoundException;
import com.clouway.test.shop.Shop2;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ShopTest2 {
  private Shop2 shop;

  @Before
  public void setUp() throws Exception {
    shop = new Shop2();
  }

  @Test
  public void sellProduct() throws Exception {
    shop.addProduct("Kiwi", new Product(1.6, 10, 100));
    assertThat(shop.sell("Kiwi", 7), is(3));
  }

  @Test
  public void anotherSellProduct() throws Exception {
    shop.addProduct("Kiwi", new Product(1.6, 10, 100));
    assertThat(shop.sell("Kiwi", 5), is(5));
  }

  @Test(expected = ProductNotFoundException.class)
  public void sellNotExistingProduct() throws Exception {
   shop.sell("Kiwi", 10);
  }

  @Test(expected = ProductNotFoundException.class)
  public void addProductAndSellNotExistingProduct() throws Exception {
    shop.addProduct("Apple", new Product(2.3, 13, 100));
    shop.sell("Orange",10);
  }

  @Test
  public void addQuantityToProduct() throws Exception {
    shop.addProduct("Kiwi", new Product(1.6, 10, 100));
    assertThat(shop.add("Kiwi", 10), is(20));
  }

  @Test
  public void addQuantityToProductAndSell() throws Exception {
    shop.addProduct("Kiwi", new Product(1.6, 10, 100));
    shop.add("Kiwi", 10);
    assertThat(shop.sell("Kiwi", 7), is(13));
  }

  @Test(expected = ProductNotFoundException.class)
  public void addQuantityToNotExistingProduct() throws Exception {
    shop.addProduct("Kiwi", new Product(1.6, 10, 100));
    shop.add("Orange", 10);
  }

  @Test
  public void sortByPrice() throws Exception {
    shop.addProduct("Kiwi", new Product(1.6, 10, 100));
    shop.addProduct("Orange", new Product(2.0, 15, 100));
    shop.addProduct("Apple", new Product(1.2, 12, 100));
    shop.addProduct("Banana", new Product(2.3, 25, 100));
    shop.addProduct("Cherry", new Product(3.5, 18, 100));
    shop.sort();
    assertThat(shop.getPriceList().get(0), is(1.2) );
    assertThat(shop.getPriceList().get(1), is(1.6) );
    assertThat(shop.getPriceList().get(2), is(2.0) );
    assertThat(shop.getPriceList().get(3), is(2.3) );
    assertThat(shop.getPriceList().get(4), is(3.5) );

  }
}
