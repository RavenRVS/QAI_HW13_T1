package ru.netology.qai.hw12.javamaven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

    Book book1 = new Book(1,"Война и мир", 1000,"Л.Н. Толстой");
    Book book2 = new Book(2,"Война миров", 1500,"Герберт Уэллс");
    Smartphone smartphone1 = new Smartphone(3,"iPhone 13", 80000,"Apple");
    Smartphone smartphone2 = new Smartphone(4,"Galaxy S22", 90000,"Samsung");

    @BeforeEach
    public void setup() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
    }

    @Test
    void removeById() {

        repo.removeById(3);

        Product[] expected = {book1, book2, smartphone2};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdWithoutIdInRepository() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }
}