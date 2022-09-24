package ru.netology.qai.hw12.javamaven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1,"Война и мир", 1000,"Л.Н. Толстой");
    Book book2 = new Book(2,"Война миров", 1500,"Герберт Уэллс");
    Smartphone smartphone1 = new Smartphone(3,"iPhone 13", 80000,"Apple");
    Smartphone smartphone2 = new Smartphone(4,"Galaxy S22", 90000,"Samsung");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    void searchByTrueInProduct() {

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("iPhone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByTrueTwoItems() {

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Война");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByTrueInBook() {

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Толстой");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByTrueInSmartphone() {

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Apple");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void searchByFalse() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Рассказ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        manager.removeById(3);

        Product[] expected = {book1, book2, smartphone2};
        Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
}