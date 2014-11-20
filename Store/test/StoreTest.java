import com.clouway.store.AddMoreThanMaxQuantityException;
import com.clouway.store.Product;
import com.clouway.store.ProductNotFoundException;
import com.clouway.store.QuantityExceedException;
import com.clouway.store.Store;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class StoreTest {
  @Test
  public void sellProduct() throws Exception {
    Store store = new Store();
    Product apple = new Product("apple", 100, 2.6);
    store.addToInventory(apple);
    store.addQuantity("apple", 12);
    assertThat(store.sell("apple", 8), is(4));

  }

  @Test
  public void sellTwoProducts() throws Exception {
    Store store = new Store();
    Product apple = new Product("apple", 100, 2.6);
    Product orange = new Product("orange", 100, 2.6);
    store.addToInventory(apple);
    store.addToInventory(orange);
    store.addQuantity("apple", 18);
    store.addQuantity("orange", 16);
    assertThat(store.sell("apple", 7), is(11));
    assertThat(store.sell("orange", 4), is(12));

  }

  @Test(expected = AddMoreThanMaxQuantityException.class)
  public void addProductToInventoryAndAddToProductQuantityMoreThanMaxQuantity() {
    Store store = new Store();
    Product apple = new Product("apple", 100, 2.6);
    store.addToInventory(apple);
    store.addQuantity("apple", 120);
    assertThat(store.sell("apple", 8), is(4));

  }

  @Test
  public void sortByPrice() throws Exception {
    Store store = new Store();
    Product apple = new Product("apple", 100, 2.6);
    Product orange = new Product("orange", 100, 3.6);
    Product banana = new Product("banana", 100, 2.8);
    Product kiwi = new Product("kiwi", 100, 3.2);
    store.addToInventory(apple);
    store.addToInventory(orange);
    store.addToInventory(banana);
    store.addToInventory(kiwi);
    List<Product> sortList = new ArrayList<Product>(store.sort());
    assertThat(sortList.get(0), is(apple));
    assertThat(sortList.get(1), is(banana));
    assertThat(sortList.get(2), is(kiwi));
    assertThat(sortList.get(3), is(orange));
  }

  @Test(expected = ProductNotFoundException.class)
  public void sellNotExistingProduct() throws Exception {
    Store store = new Store();
    Product apple = new Product("apple", 100, 2.6);
    store.addToInventory(apple);
    store.sell("orange", 15);

  }

  @Test(expected = QuantityExceedException.class)
  public void sellMoreThanHaveInStore() throws Exception {
    Store store = new Store();
    Product apple = new Product("apple", 100, 2.6);
    store.addToInventory(apple);
    store.addQuantity("apple", 12);
    store.sell("apple", 15);

  }

  @Test(expected = ProductNotFoundException.class)
  public void addQuantityToNotExistingProduct() throws Exception {
    Store store = new Store();
    Product apple = new Product("apple", 100, 2.6);
    store.addToInventory(apple);
    store.addQuantity("orange", 15);

  }
}
