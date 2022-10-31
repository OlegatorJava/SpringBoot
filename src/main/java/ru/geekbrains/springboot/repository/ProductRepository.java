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
        products.add(new Product(1, "Banana", 100));
        products.add(new Product(2, "Bread", 150));
        products.add(new Product(3, "Milk", 200));
        products.add(new Product(4, "Cheese", 235));
        products.add(new Product(5, "Apple", 91));
    }


    public Product getOnlyProduct(int id){
        Product product = products.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return product;
    }

}
