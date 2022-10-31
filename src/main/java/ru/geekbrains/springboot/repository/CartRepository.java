package ru.geekbrains.springboot.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.springboot.product.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CartRepository {

    @Autowired
    private ProductRepository productRepository;


    List<Product> productsInCart = new ArrayList<>();

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(int id) {
        this.productsInCart.add(productRepository.getOnlyProduct(id));
    }

    public void deleteProduct(int id) {
        productsInCart.removeIf(p -> p.getId() == id);
    }
}
