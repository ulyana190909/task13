package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.manager.ManagerProduct;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RepositoryProductTest {
    private RepositoryProduct repository = new RepositoryProduct();
    private ManagerProduct manager = new ManagerProduct(repository);

    private Book firstBook = new Book(1452, "Morozko", 551, "Odoevskii");
    private Book secondBook = new Book(1547, "Gadkii utenok", 520, "Andersen");
    private Book thirdBook = new Book(8652, "Repka", 600, "Tolstoi");
    private SmartPhone firstSmartPhone = new SmartPhone(59854, "iphone 11", 80999, "Apple");
    private SmartPhone secondSmartPhone = new SmartPhone(85695, "Huawei P20pro", 48000, "Huawei");
    private SmartPhone thirdSmartPhone = new SmartPhone(95845, "Sony XA Ultra", 35000, "Sony");

    @BeforeEach
    public void setUp() {
        manager = new ManagerProduct(repository);
        manager.addProduct(firstBook);
        manager.addProduct(secondBook);
        manager.addProduct(thirdBook);
        manager.addProduct(firstSmartPhone);
        manager.addProduct(secondSmartPhone);
        manager.addProduct(thirdSmartPhone);
    }

    @Test
    public void removeId() {
        int id = 1452;
        Product[] actual = repository.removeById(id);
        Product[] expected = new Product[]{secondBook, thirdSmartPhone, firstSmartPhone, secondSmartPhone, thirdSmartPhone};
        assertArrayEquals(actual, expected);
    }
}
