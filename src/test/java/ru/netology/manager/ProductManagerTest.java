package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book first = new Book(1, "Name1", 10, "Author1");
    Book second = new Book(2, "Name2", 20, "Author2");
    Book third = new Book(3, "Name3", 30, "Author3");
    TShirt fourth = new TShirt(4, "Name1", 100, "Red", "40");
    TShirt fifth = new TShirt(5, "Name2", 200, "yellow", "46");
    TShirt sixth = new TShirt(6, "Name2", 200, "yellow", "46");

    @Test
    public void DeleteAnExistingItem() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        repository.removeById(5);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, third, fourth, sixth};
        assertArrayEquals(expected, actual);

    }

    @Test
    void DeleteAnExistingItem1() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);

        int id = 3;
        repository.removeById(id);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, fourth, fifth, sixth};

        assertArrayEquals(expected, actual);
    }


    @Test
    void attemptToDeleteNonExistentItem() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);

        ProductManager manager = new ProductManager(repository);
        int id;
        id = 7;

        assertThrows(NotFoundException.class, () -> repository.removeById(id));
    }


}