package ru.geekbrains.springboot.repository;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.geekbrains.springboot.product.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    @Getter
    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init(){
        products.add(new Product(1L, "Banana", 100.00));
        products.add(new Product(2L, "Bread", 150.00));
        products.add(new Product(3L, "Milk", 200.00));
        products.add(new Product(4L, "Cheese", 235.00));
        products.add(new Product(5L, "Apple", 91.00));
    }


    public Product getOnlyProduct(Long id){
        Product product = products.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return product;
    }

    public void delete(Long id){
        Product product = products.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
        products.remove(product);
    }

}
