package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repository.RepositoryProduct;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerProductTest {
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
    public void findSmartPhoneSony() {
        String text = "Sony";
        Product[] actual = manager.searchBy(text);
        Product[] expected = new Product[]{thirdSmartPhone};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void findSmartPhoneApple() {
        String text = "iphone 11";
        Product[] actual = manager.searchBy(text);
        Product[] expected = new Product[]{firstSmartPhone};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void findSmartPhoneHuawei() {
        String text = "Huawei";
        Product[] actual = manager.searchBy(text);
        Product[] expected = new Product[]{secondSmartPhone};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void findBookRepka() {
        String text = "Repka";
        Product[] actual = manager.searchBy(text);
        Product[] expected = new Product[]{thirdBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findBookMorozko() {
        String text = "Morozko";
        Product[] actual = manager.searchBy(text);
        Product[] expected = new Product[]{firstBook};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void findBookAndersen() {
        String text = "Andersen";
        Product[] actual = manager.searchBy(text);
        Product[] expected = new Product[]{secondBook};
        assertArrayEquals(actual, expected);
    }

}
