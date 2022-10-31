package ru.geekbrains.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.springboot.product.Product;
import ru.geekbrains.springboot.repository.CartRepository;
import ru.geekbrains.springboot.repository.ProductRepository;



@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;



    @GetMapping("/product/{id}")
    public String getOnlyProduct(Model model, @PathVariable int id){
        Product product = productRepository.getOnlyProduct(id);
        model.addAttribute("product", product);
        return "onlyProduct";
    }

    @GetMapping("/product/all")
    public String getAllProduct(Model model){
        model.addAttribute("products", productRepository.getProducts());
        return "allProducts";
    }

    @GetMapping("/cart/{id}")
    public String cart(Model model, @PathVariable int id){
        cartRepository.setProductsInCart(id);
        model.addAttribute("cart", cartRepository.getProductsInCart());
        return "cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String delete(Model model, @PathVariable int id){
        cartRepository.deleteProduct(id);
        model.addAttribute("cart", cartRepository.getProductsInCart());
        return "cart";
    }
}
