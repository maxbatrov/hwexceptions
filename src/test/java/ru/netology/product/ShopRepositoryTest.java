package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    @Test
    public void testRemoveProductExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(12, "Хлеб", 80);
        Product product2 = new Product(22, "Молоко", 90);
        Product product3 = new Product(32, "Яйца", 100);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(12);

        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveProductNotExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(12, "Хлеб", 80);
        Product product2 = new Product(22, "Молоко", 90);
        Product product3 = new Product(32, "Яйца", 100);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(10));
    }
}