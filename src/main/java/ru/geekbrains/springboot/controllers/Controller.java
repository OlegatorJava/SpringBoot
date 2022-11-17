package ru.geekbrains.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.springboot.product.Product;
import ru.geekbrains.springboot.repository.CartRepository;
import ru.geekbrains.springboot.repository.ProductRepository;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;



    @GetMapping("/product/{id}")
    public Product getOnlyProduct(@PathVariable Long id){
        return productRepository.getOnlyProduct(id);
    }


    @GetMapping("/product/all")
    public List<Product> getAllProduct(){
        return productRepository.getProducts();
    }

    @GetMapping("/product/delete")
    public void delete(@RequestParam Long id){
        productRepository.delete(id);

    }

    @GetMapping("/cart")
    public List<Product> cart(){
        return cartRepository.getProductsInCart();
    }

    @GetMapping("/cart/add")
    public void add(@RequestParam Long id){
        cartRepository.setProductsInCart(id);

    }

    @GetMapping("/cart/delete")
    public void deleteProductInCart(@RequestParam Long id){
        cartRepository.deleteProduct(id);

    }
}
