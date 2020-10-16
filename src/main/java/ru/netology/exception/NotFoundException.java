package ru.netology.exception;

import ru.netology.domain.Product;
import ru.netology.repository.RepositoryProduct;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Product[] createException() {
        RepositoryProduct repository = new RepositoryProduct();
        if (repository.removeById(111) == null) {
            try {
                System.out.println("before remove");
                repository.removeById(111);
                System.out.println("after remove");
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                System.out.println("specific catch");
            } catch (RuntimeException cat) {
                System.out.println("runtime catch");
            } catch (Exception cat) {
                System.out.println("exception catch");
            } finally {
                System.out.println("finally");
            }
            System.out.println("well done");
        }
        return new Product[0];
    }
}
