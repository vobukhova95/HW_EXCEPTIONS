import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.qa.AlreadyExistsException;
import ru.netology.qa.NotFoundException;
import ru.netology.qa.Product;
import ru.netology.qa.ShopRepository;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();
    Product item1 = new Product(1, "Хлеб", 100);
    Product item2 = new Product(2, "Молоко", 150);
    Product item3 = new Product(2, "Яблоко", 200);

    @Test
    public void shouldRemoveById() {
        repo.add(item1);
        repo.add(item2);
        repo.remove(1);

        Product[] expected = {item2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveById() {
        repo.add(item1);
        repo.add(item2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(333);
        });


    }

    @Test
    public void shouldAddItem() {
        repo.add(item2);

        Product[] expected = {item2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAddItem() {
        repo.add(item2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.add(item3));


    }
}
